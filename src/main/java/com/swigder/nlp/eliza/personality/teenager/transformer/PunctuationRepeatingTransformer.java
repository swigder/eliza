package com.swigder.nlp.eliza.personality.teenager.transformer;

import com.swigder.nlp.eliza.transformer.OutputTransformer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Repeats ? and ! three times.
 */
@Component
@Order(value = 1)
public class PunctuationRepeatingTransformer implements OutputTransformer {
    @Override
    public String transform(String input) {
        return input.replaceAll("([?!])", "$1$1$1");
    }
}
