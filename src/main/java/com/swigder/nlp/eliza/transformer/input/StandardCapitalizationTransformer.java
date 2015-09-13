package com.swigder.nlp.eliza.transformer.input;


import com.swigder.nlp.eliza.transformer.Transformer;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Transforms the input to standard capitalization for easier pattern matching.
 */
@Component
public class StandardCapitalizationTransformer implements Transformer {

    private final Pattern firstPersonI = Pattern.compile("(^|\\W)i($|\\W)");

    @Override
    public String transform(String input) {
        String transformed = input; // ideally we'd handle CAPS LOCK / yelling here, but this brings complications for proper nouns

        transformed = input.substring(0, 1).toUpperCase() + input.substring(1); // capitalize first letter

        Matcher matcher = firstPersonI.matcher(transformed); // capitalize I
        transformed = matcher.replaceAll("$1I$2");

        return transformed;
    }
}
