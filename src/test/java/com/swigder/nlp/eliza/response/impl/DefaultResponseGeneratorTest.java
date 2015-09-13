package com.swigder.nlp.eliza.response.impl;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultResponseGeneratorTest {

    private DefaultResponseGenerator generator = new DefaultResponseGenerator();

    @Test
    public void respondsToAnything() {
        String actual = generator.generateResponse(RandomStringUtils.random(50));
        assertThat(actual, anyOf(
                equalTo("I don't know what to say to that."),
                equalTo("Tell me more about that."),
                equalTo("Please elaborate."),
                equalTo("Go on.")
        ));
    }
}
