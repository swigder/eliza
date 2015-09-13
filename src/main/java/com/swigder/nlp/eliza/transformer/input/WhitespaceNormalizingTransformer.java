package com.swigder.nlp.eliza.transformer.input;

import com.swigder.nlp.eliza.transformer.Transformer;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xx on 9/13/15.
 */
@Component
public class WhitespaceNormalizingTransformer implements Transformer {
    private final Pattern whitespace = Pattern.compile("\\s+");

    @Override
    public String transform(String input) {
        Matcher matcher = whitespace.matcher(input);
        return matcher.replaceAll(" ");
    }
}
