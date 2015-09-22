package com.swigder.nlp.eliza.transformer.input;

import com.swigder.nlp.eliza.transformer.InputTransformer;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Removes all punctuation.  This makes matching easier as individual regex's do
 * not have to account for optional punctuation, but means that generators can't use
 * ? or ! to identify a question or excitement.
 */
@Component
public class PunctuationRemovingTranformer implements InputTransformer {

    private final Pattern punctuation = Pattern.compile("([.?!]+$|,)");

    @Override
    public String transform(String input) {
        Matcher matcher = punctuation.matcher(input);
        return matcher.replaceAll("");
    }
}
