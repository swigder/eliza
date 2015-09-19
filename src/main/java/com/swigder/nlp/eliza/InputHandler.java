package com.swigder.nlp.eliza;

import com.swigder.nlp.eliza.response.ResponseGenerator;
import com.swigder.nlp.eliza.transformer.InputTransformer;
import com.swigder.nlp.eliza.transformer.OutputTransformer;
import com.swigder.nlp.eliza.transformer.Transformer;

import java.util.List;

/**
 * Created by xx on 9/12/15.
 */
public class InputHandler {

    private final List<InputTransformer> inputTransformers;
    private final List<ResponseGenerator> responseGenerators;
    private final List<OutputTransformer> responseTransformers;

    public InputHandler(List<InputTransformer> inputTransformers, List<ResponseGenerator> responseGenerators, List<OutputTransformer> responseTransformers) {
        this.inputTransformers = inputTransformers;
        this.responseGenerators = responseGenerators;
        this.responseTransformers = responseTransformers;
    }

    /**
     * Generates a response to a given input
     * @param input
     * @return
     */
    public String handleInput(String input) {

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
