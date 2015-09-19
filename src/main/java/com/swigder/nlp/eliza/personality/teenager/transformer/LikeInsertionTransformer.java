package com.swigder.nlp.eliza.personality.teenager.transformer;

import com.swigder.nlp.eliza.transformer.OutputTransformer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Randomly inserts like into some responses.
 */
@Component
@Order(value = 1)
public class LikeInsertionTransformer implements OutputTransformer {

    private final Random random = new Random();
    private static final int CHANCE_TO_START_WITH_LIKE = 25;
    private static final int CHANCE_TO_INSERT_LIKE = 25;

    @Override
    public String transform(String input) {
        if (random.nextInt(CHANCE_TO_START_WITH_LIKE) == 0) {
            return "Like " + input.substring(0, 1).toLowerCase() + input.substring(1);
        }
        return input;
    }
}
