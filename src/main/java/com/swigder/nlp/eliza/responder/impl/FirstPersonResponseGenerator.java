package com.swigder.nlp.eliza.responder.impl;

import com.google.common.collect.ImmutableMap;
import com.swigder.nlp.eliza.responder.ResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

/**
 * Finds instances of the first person and transforms to second person.
 * Is not specific to content and is not combined with other response generators.
 */
@Component
@Order(value = 4)
public class FirstPersonResponseGenerator implements ResponseGenerator {

    // for inverse map, higher values will be used
    private final Map<String, String> pronouns = ImmutableMap.<String, String>builder()
            .put("my", "your")
            .put("myself", "yourself")
            .put("mine", "yours")
            .put("(i|me)", "you")
            .build();

    private final Random random = new Random();

    @Override
    public String generateResponse(String input) {
        input = input.toLowerCase();

        if (!hasFirstPerson(input) || random.nextInt(3) == 0) { // only want to catch some of these; some should go to default
            return null;
        }

        for (String pronoun : pronouns.keySet()) {
            input = input.replaceAll(word(pronoun), " TOKEN ");
            if (pronoun != "(i|me)") {
                input = input.replaceAll(word(pronouns.get(pronoun)), " " + pronoun + " ");
            }
            else { // ugly special handling of you that doesn't quite work but is a start given the only tool is regex
                input = input.replaceAll("^you\\b", "I");
                input = input.replaceAll(word("you"), "me");
            }
            input = input.replaceAll("TOKEN", pronouns.get(pronoun));
        }

        input = input.trim().replaceAll("\\s\\s+", " "); // todo simplest way to make red tests go green

        return "Why do you think " + input + "?"; // copout to not have to worry about tense
    }

    private boolean hasFirstPerson(String string) {
        for (String pronoun : pronouns.keySet()) {
            if (string.matches(".*" + word(pronoun) + ".*")) {
                return true;
            }
        }
        return false;
    }

    private String word(String word) {
        return "\\b" + word + "\\b";
    }
}
