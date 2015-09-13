package com.swigder.nlp.eliza.response.abstr;

import com.google.common.collect.ImmutableMap;
import com.swigder.nlp.eliza.response.ResponseGenerator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Replaces given regular expressions.
 * Subclasses should provide a map of patterns to their replacements.
 */
public abstract class MappedPatternResponseGenerator implements ResponseGenerator {
    private final Map<Pattern, String> patterns;

    public MappedPatternResponseGenerator(Map<Pattern, String> patterns) {
        this.patterns = patterns;
    }

    @Override
    public String generateResponse(String input) {

        for (Pattern pattern : patterns.keySet()) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return matcher.replaceFirst(patterns.get(pattern));
            }
        }

        return null;
    }

}
