package com.swigder.nlp.eliza.responder.impl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BecauseResponseGeneratorTest {

    BecauseResponseGenerator generator = new BecauseResponseGenerator();

    @Test
    public void becauseIAmASomething() {
        String actual = generator.generateResponse("Because I am a cat");
        assertThat(actual, anyOf(equalTo("Why are you a cat?"), equalTo("Since when have you been a cat?")));
    }

    @Test
    public void becauseSHeIsSomething() {
        String actual = generator.generateResponse("Because she is the worst person in the world");
        assertThat(actual, anyOf(equalTo("Why do you think she is like that?")));
    }

    @Test
    public void becauseTheyAreSomething() {
        String actual = generator.generateResponse("Because they are terrible people");
        assertThat(actual, anyOf(equalTo("Why do you think they are like that?")));
    }

    @Test
    public void becauseGeneric() {
        String actual = generator.generateResponse("Because I have nothing more to say to you");
        assertThat(actual, anyOf(equalTo("Do you think that is a good reason?"), equalTo("Please elaborate on that."), equalTo("Go on.")));
    }

    @Test
    public void nonMatch() {
        String actual = generator.generateResponse("Something else");
        assertThat(actual, nullValue());
    }
}
