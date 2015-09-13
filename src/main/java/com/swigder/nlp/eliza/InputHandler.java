package com.swigder.nlp.eliza;

import com.swigder.nlp.eliza.response.ResponseGenerator;
import com.swigder.nlp.eliza.transformer.Transformer;

import java.util.List;

/**
 * Created by xx on 9/12/15.
 */
public class InputHandler {

    private final List<Transformer> inputTransformers;
    private final List<ResponseGenerator> responseGenerators;

    public InputHandler(List<Transformer> inputTransformers, List<ResponseGenerator> responseGenerators) {
        this.inputTransformers = inputTransformers;
        this.responseGenerators = responseGenerators;
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
            String transformed = responseGenerator.generateResponse(input);
            if (transformed != null) {
                return transformed;
            }
        }

        return "";
    }
}
