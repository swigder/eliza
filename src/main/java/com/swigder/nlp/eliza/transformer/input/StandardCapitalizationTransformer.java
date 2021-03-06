package com.swigder.nlp.eliza.transformer.input;


import com.swigder.nlp.eliza.transformer.InputTransformer;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Transforms the input to standard capitalization for easier pattern matching.
 * This means that the first letter of each sentence and the word 'I' will be capitalized.
 * #TODO should've actually just used case-insensitive compare (wrapping Pattern to only have to do it once)
 */
@Component
public class StandardCapitalizationTransformer implements InputTransformer {

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
