package com.swigder.nlp.eliza.responder;

/**
 * Generates a responder for a given input.
 */
public interface ResponseGenerator {
    /**
     * Transforms a given input if it is able to do so.
     * @param input the input for which to generate a responder.  Should be trimmed and punctuation-less.
     * @return an appropriate responder if the generator is able to generate one for the input, null otherwise
     */
    public String generateResponse(String input);
}
