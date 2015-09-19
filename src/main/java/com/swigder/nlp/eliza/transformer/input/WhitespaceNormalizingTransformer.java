package com.swigder.nlp.eliza.transformer.input;

import com.swigder.nlp.eliza.transformer.InputTransformer;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Normalizes whitespace in the input, converting any number of consecutive whitespace characters into a single space.
 */
@Component
public class WhitespaceNormalizingTransformer implements InputTransformer {
    private final Pattern whitespace = Pattern.compile("\\s+");

    @Override
    public String transform(String input) {
        Matcher matcher = whitespace.matcher(input);
        return matcher.replaceAll(" ");
    }
}
