package com.swigder.nlp.eliza.response;

/**
 * Generates a response for a given input.
 */
public interface ResponseGenerator {
    /**
     * Transforms a given input if it is able to do so.
     * @param input the input for which to generate a response.  Should be trimmed and punctuation-less.
     * @return an appropriate response if the generator is able to generate one for the input, null otherwise
     */
    public String generateResponse(String input);
}
