package com.swigder.nlp.eliza.transformer.input;

import com.swigder.nlp.eliza.transformer.Transformer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Trims the input.  Should happen first.
 */
@Component
@Order(value = Integer.MIN_VALUE)
public class TrimmingTransformer implements Transformer {
    @Override
    public String transform(String input) {
        return input.trim();
    }
}
