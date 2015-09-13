package com.swigder.nlp.eliza.response.impl;

import com.swigder.nlp.eliza.collections.ScalarListMapBuilder;
import com.swigder.nlp.eliza.response.abstr.RandomResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Generates generic responses using the content of the input, but based only on the form, not content, of input.
 * This class can recognize various formats of sentences and respond to them.
 */
@Component
@Order (value = 2)
public class GenericResponseGenerator extends RandomResponseGenerator {
    private static final Map<Pattern, List<String>> patterns = new ScalarListMapBuilder<Pattern, String>()
            .put(Pattern.compile("^(?:This|That|It)(?: is|'s) (\\w+)"), "Why is it $1?", "Why do you think it is $1?", "Do you care that it is $1?", "Tell me why it is $1.")
            .put(Pattern.compile("^My ([\\w+\\s]+) (are|have|is) (\\w+)"), "Tell me more about your $1.", "Why $2 your $1 $3?", "Why do you think your $1 $2 $3?")
            .put(Pattern.compile("^My ([\\w+\\s]+) (are|have|is) .*"), "Tell me more about your $1.")
            .build();

    public GenericResponseGenerator() {
        super(patterns);
    }

}
