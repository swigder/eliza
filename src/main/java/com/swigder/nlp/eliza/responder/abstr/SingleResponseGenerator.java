package com.swigder.nlp.eliza.responder.abstr;

import com.swigder.nlp.eliza.responder.ResponseGenerator;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Returns a single responder for any input that matches the given patterns.
 * The responder must be a static string and must not contain back-references
 */
public abstract class SingleResponseGenerator implements ResponseGenerator {
    private final List<Pattern> patterns;
    private final String response;

    /**
     * @param patterns list of patterns to return a responder for
     * @param response responder to provide for all patterns
     */
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
