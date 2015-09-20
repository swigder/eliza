package com.swigder.nlp.eliza.responder.impl;

import com.swigder.nlp.eliza.collections.ScalarListMapBuilder;
import com.swigder.nlp.eliza.responder.abstr.RandomResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Responds to inputs starting with "Because"
 */
@Component
@Order(value = 2)
public class BecauseResponseGenerator extends RandomResponseGenerator {
    private static final Map<Pattern, List<String>> patterns = new ScalarListMapBuilder<Pattern, String>()
            .put(Pattern.compile("Because (?:I am|I'm) (.*)"), "Why are you $1?", "Since when have you been $1?")
            .put(Pattern.compile("Because (he|she|they) (is|are).*"), "Why do you think $1 $2 like that?")
            .put(Pattern.compile("Because.*"), "Do you think that is a good reason?", "Please elaborate on that.", "Go on.")
            .build();

    public BecauseResponseGenerator() {
        super(patterns);
    }

}
