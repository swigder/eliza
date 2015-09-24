package com.swigder.nlp.eliza.personality.teenager.transformer;

import com.swigder.nlp.eliza.transformer.OutputTransformer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Converts output to lower case.
 * Should happen before other transforms as they rely on input being lowercase.
 */
@Component
@Order(value = Integer.MIN_VALUE)
public class ToLowerTransformer implements OutputTransformer {
    @Override
    public String transform(String input) {
        return input.toLowerCase();
    }
}
