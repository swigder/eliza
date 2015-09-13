package com.swigder.nlp.eliza.response.abstr;

import com.swigder.nlp.eliza.response.ResponseGenerator;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Returns a single response for any input that matches the given patterns.
 */
public abstract class SingleResponseGenerator implements ResponseGenerator {
    private final List<Pattern> patterns;
    private final String response;

    protected SingleResponseGenerator(List<Pattern> patterns, String response) {
        this.patterns = patterns;
        this.response = response;
    }

    @Override
    public String generateResponse(String input) {
        for (Pattern pattern : patterns) {
            if (pattern.matcher(input).matches()) {
                return response;
            }
        }
        return null;
    }

}
