package com.swigder.nlp.eliza.responder.impl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GenericResponseGeneratorTest {
    GenericResponseGenerator generator = new GenericResponseGenerator();

    @Test
    public void yes() {
        String actual = generator.generateResponse("It is horrible");
        assertThat(actual, anyOf(equalTo("Why is it horrible?"), equalTo("Why do you think it is horrible?"), equalTo("Do you care that it is horrible?"), equalTo("Tell me why it is horrible.")));
    }

    @Test
    public void no() {
        String actual = generator.generateResponse("It's horrible");
        assertThat(actual, anyOf(equalTo("Why is it horrible?"), equalTo("Why do you think it is horrible?"), equalTo("Do you care that it is horrible?"), equalTo("Tell me why it is horrible.")));
    }

    @Test
    public void maybe() {
        String actual = generator.generateResponse("My friends are mean");
        assertThat(actual, anyOf(equalTo("Tell me more about your friends."), equalTo("Why are your friends mean?"), equalTo("Why do you think your friends are mean?")));
    }

    @Test
    public void ok() {
        String actual = generator.generateResponse("My horrible sister is a witch");
        assertThat(actual, anyOf(equalTo("Tell me more about your horrible sister.")));
    }

    @Test
    public void okay() {
        String actual = generator.generateResponse("My horrible sister is a witch");
        assertThat(actual, anyOf(equalTo("Tell me more about your horrible sister.")));
    }
}
