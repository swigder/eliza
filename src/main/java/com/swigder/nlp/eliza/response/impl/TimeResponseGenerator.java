package com.swigder.nlp.eliza.response.impl;

import com.swigder.nlp.eliza.collections.ScalarListMapBuilder;
import com.swigder.nlp.eliza.response.abstr.RandomResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Component
@Order(value = 1)
public class TimeResponseGenerator extends RandomResponseGenerator {
    private static final Map<Pattern, List<String>> patterns = new ScalarListMapBuilder<Pattern, String>()
            .put(Pattern.compile("Since (last )?(\\w)"), "What happened $1$2")
            .put(Pattern.compile("(Yesterday)"), "What happened $1$2")
            .build();

    public TimeResponseGenerator() {
        super(patterns);
    }
}
