package com.swigder.nlp.eliza.response.impl;

import com.swigder.nlp.eliza.collections.ScalarListMapBuilder;
import com.swigder.nlp.eliza.response.ResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Responds to inputs of one word
 */
@Component
@Order(value = 1)
public class OneWordInputResponseGenerator implements ResponseGenerator {
    private static final Map<String, List<String>> responses = new ScalarListMapBuilder<String, String>()
            .put("Yes", "Why?")
            .put("No", "Why not?", "Do you wish it were different?")
            .put("Maybe", "Why are you unsure?", "What would make you more sure?", "Do you wish you knew?")
            .put("(Ok|Okay|OK)", "Can you say something more than $1?", "Why are you so ambivalent today?")
            .build();

    Random random = new Random();


    @Override
    public String generateResponse(String input) {
        if (input.split("\\s").length != 1) { // we handle only one word inputs.
            return null;
        }

        if (responses.keySet().contains(input)) {
            List<String> possibleAnswers = responses.get(input);
            return possibleAnswers.get(random.nextInt(possibleAnswers.size()));
        }

        return "Please elaborate.";
    }
}
