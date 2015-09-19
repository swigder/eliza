package com.swigder.nlp.eliza.personality.teenager.responder;

import com.google.common.collect.Lists;
import com.swigder.nlp.eliza.responder.abstr.SingleResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Responds to any mention of parents by expressing annoyance at parents in general.
 */
@Component
@Order(value = 2)
public class ParentResponseGenerator extends SingleResponseGenerator {

    private static final List<Pattern> patterns = Lists.newArrayList(
            Pattern.compile(".*\\b[mM]other.*"),
            Pattern.compile(".*\\b[fF]ather.*"),
            Pattern.compile(".*\\bparent.*")
    );

    private static final String response = "Parents are like so annoying.";

    private ParentResponseGenerator() {
        super(patterns, response);
    }
}
