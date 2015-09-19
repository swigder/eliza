package com.swigder.nlp.eliza.response.impl;

import com.swigder.nlp.eliza.collections.ScalarListMapBuilder;
import com.swigder.nlp.eliza.response.abstr.RandomResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Responds to questions
 */
@Component
@Order (value = 1)
public class QuestionResponseGenerator extends RandomResponseGenerator {

    private static final Map<Pattern, List<String>> patterns = new ScalarListMapBuilder<Pattern, String>()
            .put(Pattern.compile("^(Why|Do|How).*"), "Why do you ask?", "What do you think?", "What do you think the answer is?")
            .build();

    public QuestionResponseGenerator() {
        super(patterns);
    }
}
