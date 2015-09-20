package com.swigder.nlp.eliza.responder.impl;

import com.swigder.nlp.eliza.collections.ScalarListMapBuilder;
import com.swigder.nlp.eliza.responder.ResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Responds to inputs of one word
 */
@Component
@Order(value = 3)
public class OneWordInputResponseGenerator implements ResponseGenerator {
    protected static final Map<String, List<String>> responses = new ScalarListMapBuilder<String, String>()
            .put("yes", "Why?")
            .put("no", "Why not?", "Do you wish it were different?")
            .put("maybe", "Why are you unsure?", "What would make you more sure?", "Do you wish you knew?")
            .put("ok", "Can you say something more than ok?", "Why are you so ambivalent today?")
            .put("okay", "Can you say something more than okay?", "Why are you so ambivalent today?")
            .build();

    protected static final String defaultAnswer = "Please elaborate.";

    Random random = new Random();


    @Override
    public String generateResponse(String input) {
        if (input.split("\\s").length != 1) { // we handle only one word inputs.
            return null;
        }

        if (responses.keySet().contains(input.toLowerCase())) {
            List<String> possibleAnswers = responses.get(input);
            return possibleAnswers.get(random.nextInt(possibleAnswers.size()));
        }

        return defaultAnswer;
    }
}
