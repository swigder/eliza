package com.swigder.nlp.eliza;

import com.swigder.nlp.eliza.responder.ResponseGenerator;
import com.swigder.nlp.eliza.transformer.InputTransformer;
import com.swigder.nlp.eliza.transformer.OutputTransformer;
import com.swigder.nlp.eliza.transformer.Transformer;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Generates a responder given an input.
 * This class will use configured transformers and responder generators to
 * normalize the input, generate a responder given the input, and modify the
 * responder.
 */
public class InputHandler {

    private final List<InputTransformer> inputTransformers;
    private final List<ResponseGenerator> responseGenerators;
    private final List<OutputTransformer> responseTransformers;

    /**
     * @param inputTransformers list of transformers to normalize the input so that it conforms to the required input for the responder generators
     * @param responseGenerators list of responder generators, which should be provided in the order they will be run, with later generators run only if earlier ones do not provide a responder
     * @param responseTransformers list of responder transformers, which can be used, for example, to translate the responses or give them personality
     */
    public InputHandler(List<InputTransformer> inputTransformers, List<ResponseGenerator> responseGenerators, List<OutputTransformer> responseTransformers) {
        this.inputTransformers = inputTransformers;
        this.responseGenerators = responseGenerators;
        this.responseTransformers = responseTransformers;
    }

    /**
     * Generates a responder to a given input
     * @param input the string to respond to
     * @return responder to display to the user
     */
    public String handleInput(String input) {
        if (StringUtils.isEmpty(input)) {
            return "Please say something."; // TODO should be configured
        }

        for (Transformer transformer : inputTransformers) {
            input = transformer.transform(input);
        }

        for (ResponseGenerator responseGenerator : responseGenerators) {
            String response = responseGenerator.generateResponse(input);
            if (response != null) {
                for (Transformer transformer : responseTransformers) {
                    response = transformer.transform(response);
                }
                return response;
            }
        }

        return "";
    }
}
