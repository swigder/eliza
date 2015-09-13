package com.swigder.nlp.eliza.response.impl;

import com.google.common.collect.ImmutableList;
import com.swigder.nlp.eliza.response.abstr.RandomResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Response generator to help start a discussion when the patient is unsure of what to say.
 */
@Component
@Order (value = 1)
public class WhatToSayResponseGenerator extends RandomResponseGenerator {
    private static final List<Pattern> patterns = ImmutableList.of(
            Pattern.compile("Hello|Hi"),
            Pattern.compile("I .* (what|anything) to (say|tell).*"),
            Pattern.compile("What.*(say|tell).*")
    );
    private static final List<String> responses = ImmutableList.of(
            "Tell me about your day.",
            "How are you feeling today?",
            "Let's discuss your thoughts."
    );

    public WhatToSayResponseGenerator() {
        super(patterns, responses);
    }
}
