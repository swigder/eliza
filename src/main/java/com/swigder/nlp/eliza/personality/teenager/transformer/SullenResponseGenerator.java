package com.swigder.nlp.eliza.personality.teenager.transformer;

import com.google.common.collect.Lists;
import com.swigder.nlp.eliza.transformer.OutputTransformer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * Randomly replaces the output with a sullen responder.
 */
@Component
@Order(value = Integer.MAX_VALUE)
public class SullenResponseGenerator implements OutputTransformer {
    private final Random random = new Random();
    private static final int CHANCE_TO_REPLACE_WITH_SULLEN_RESPONSE = 25;

    private static final List<String> sullenResponses = Lists.newArrayList("like i care.", "wtvr");

    @Override
    public String transform(String input) {
        if (random.nextInt(CHANCE_TO_REPLACE_WITH_SULLEN_RESPONSE) == 0) {
            return sullenResponses.get(random.nextInt(sullenResponses.size()));
        }

        return input;
    }
}
