package com.swigder.nlp.eliza.prompter.impl;

import com.google.common.collect.ImmutableList;
import com.swigder.nlp.eliza.prompter.Prompter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * This default initial prompter provides some prompts to help the conversation
 * get started when the app is first launched.
 * These prompts are meant to encourage the user to talk about his or her feelings.
 */
@Component
public class DefaultInitialPrompter implements Prompter {

    private static final List<String> prompts = ImmutableList.of(
            "How are you today?",
            "How are you feeling today?",
            "How are you doing today?",
            "Let's talk about why you're here.",
            "Why are you here today?"
    );
    private final Random random = new Random();

    @Override
    public String prompt() {
        return prompts.get(random.nextInt(prompts.size()));
    }
}
