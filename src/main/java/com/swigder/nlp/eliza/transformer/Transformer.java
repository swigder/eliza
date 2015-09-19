package com.swigder.nlp.eliza.transformer;

/**
 * Transforms one string into another string.
 */
public interface Transformer {
    /**
     * Transform a string into another string
     * @param input string to be transformed
     * @return transformed string
     */
    public String transform(String input);
}
