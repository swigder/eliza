package com.swigder.nlp.eliza.responder.impl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OneWordInputResponseGeneratorTest {
    OneWordInputResponseGenerator generator = new OneWordInputResponseGenerator();

    @Test
    public void yes() {
        String actual = generator.generateResponse("yes");
        assertThat(actual, anyOf(equalTo("Why?")));
    }

    @Test
    public void yesMulticase() {
        String actual = generator.generateResponse("YeS");
        assertThat(actual, anyOf(equalTo("Why?")));
    }

}
