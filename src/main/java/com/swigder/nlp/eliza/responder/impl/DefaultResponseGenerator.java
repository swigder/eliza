package com.swigder.nlp.eliza.responder.impl;

import com.google.common.collect.Lists;
import com.swigder.nlp.eliza.responder.ResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * Default responder generator to be used when no other generator has a responder.
 * These responses have nothing to do with the input.
 */
@Component
@Order (value = Integer.MAX_VALUE)
public class DefaultResponseGenerator implements ResponseGenerator {

    private final List<String> responses = Lists.newArrayList(
            "I don't know what to say to that.",
            "Tell me more about that.",
            "Please elaborate.",
            "Go on."
    );
    private final Random random = new Random();

    @Override
    public String generateResponse(String input) {
        return responses.get(random.nextInt(responses.size()));
    }
}
