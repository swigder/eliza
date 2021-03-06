package com.swigder.nlp.eliza.responder.impl;

import com.swigder.nlp.eliza.collections.ScalarListMapBuilder;
import com.swigder.nlp.eliza.responder.abstr.RandomResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Detects uncertainty and tries to build on that
 */
@Component
@Order(value = 1)
public class UncertaintyResponseGenerator extends RandomResponseGenerator {
    private static final Map<Pattern, List<String>> patterns = new ScalarListMapBuilder<Pattern, String>()
            .put(Pattern.compile("Maybe.*"), "Why aren't you sure?")
            .put(Pattern.compile("^.+(may|might).+"), "Why aren't you sure?")
            .build();

    public UncertaintyResponseGenerator() {
        super(patterns);
    }

}
