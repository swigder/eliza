package com.swigder.nlp.eliza.responder.abstr;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.swigder.nlp.eliza.responder.ResponseGenerator;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Returns one of a list of responses for given inputs, at random.
 * If an input matches multiple patterns, the earliest pattern match will be used.
 * Configured responses may use back-references.
 */
public class RandomResponseGenerator implements ResponseGenerator {
    private final Map<List<Pattern>, List<String>> patterns;
    private final Random random = new Random();

    /**
     * @param pattern regex for which to provide a responder
     * @param responses list of responses appropriate for the input
     */
    public RandomResponseGenerator(Pattern pattern, List<String> responses) {
        List<Pattern> patterns = Lists.newArrayList(pattern);
        this.patterns = ImmutableMap.of(patterns, responses);
    }

    /**
     * @param patterns map of patterns to a list of appropriate responses
     */
    public RandomResponseGenerator(Map<Pattern, List<String>> patterns) {
        this.patterns = Maps.newLinkedHashMap();
        for (Pattern pattern : patterns.keySet()) {
            this.patterns.put(Lists.newArrayList(pattern), patterns.get(pattern));
        }
    }

    /**
     * @param patterns list of patterns for which to provide a responder
     * @param responses list of responses that match all given patterns
     */
    public RandomResponseGenerator(List<Pattern> patterns, List<String> responses) {
        this.patterns = ImmutableMap.of(patterns, responses);
    }

    @Override
    public String generateResponse(String input) {

        for (List<Pattern> patternList : patterns.keySet()) {
            for (Pattern pattern : patternList) {
                Matcher matcher = pattern.matcher(input);
                if (matcher.matches()) {
                    List<String> responses = patterns.get(patternList);
                    return matcher.replaceFirst(responses.get(random.nextInt(responses.size())));
                }
            }
        }

        return null;
    }

}
