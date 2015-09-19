package com.swigder.nlp.eliza.response.impl;

import com.google.common.collect.Lists;
import com.swigder.nlp.eliza.response.abstr.SingleResponseGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

/**
 * This transformer advises suicidal patients to seek help from someone better suited to the task.
 * This is a very important transformer and is thus put first on the list.
 */
@Component
@Order(value = Integer.MIN_VALUE)
public class SuicidePreventionResponseGenerator extends SingleResponseGenerator {

    private static final List<Pattern> patterns = Lists.newArrayList(
            Pattern.compile(".*[sS]uicide.*"),
            Pattern.compile("I want to die"),
            Pattern.compile(".*kill myself")
    );

    private static final String advice = "Please contact the National Suicide Prevention Lifeline at 1 (800) 273-8255.";

    public SuicidePreventionResponseGenerator() {
        super(patterns, advice);
    }
}
