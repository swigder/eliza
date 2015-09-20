package com.swigder.nlp.eliza.responder.impl;

import com.google.common.collect.Lists;
import com.swigder.nlp.eliza.responder.abstr.SingleResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Advises the patient to talk about him or herself.
 * Since this has a very general regex matcher, it should be put lower on the stack.
 */
@Component
@Order (value = 5)
public class PatientFocusResponseGenerator extends SingleResponseGenerator {
    private static final List<Pattern> patterns = Lists.newArrayList(
            Pattern.compile(".*you.*")
    );

    private static final String advice = "Let's talk about you today, okay?";

    public PatientFocusResponseGenerator() {
        super(patterns, advice);
    }

}
