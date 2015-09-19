package com.swigder.nlp.eliza.transformer.input;

import com.swigder.nlp.eliza.transformer.InputTransformer;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xx on 9/13/15.
 */
@Component
public class PunctuationRemovingTranformer implements InputTransformer {

    private final Pattern punctuation = Pattern.compile("[.?!,]+");

    @Override
    public String transform(String input) {
        Matcher matcher = punctuation.matcher(input);
        return matcher.replaceAll("");
    }
}
