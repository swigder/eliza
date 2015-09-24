package com.swigder.nlp.eliza.responder.impl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class FirstPersonResponseGeneratorTest {
    FirstPersonResponseGenerator generator = new FirstPersonResponseGenerator();

    @Test
    public void iLikeToEat() {
        String actual = null;
        while (actual == null) actual = generator.generateResponse("I like to eat");
        assertThat(actual, is("Why do you think you like to eat?"));
    }

    @Test
    public void youMakeMeThink() {
        String actual = null;
        while (actual == null) actual = generator.generateResponse("You make me think");
        assertThat(actual, is("Why do you think I make you think?"));
    }

    @Test
    public void iDontLikeMyself() {
        String actual = null;
        while (actual == null) actual = generator.generateResponse("I don't like myself");
        assertThat(actual, is("Why do you think you don't like yourself?"));
    }

    @Test
    public void myCatWantsToKillMyDog() {
        String actual = null;
        while (actual == null) actual = generator.generateResponse("My cat wants to kill my dog");
        assertThat(actual, is("Why do you think your cat wants to kill your dog?"));
    }

    @Test
    public void doesntFalsePositive() {
        String actual = generator.generateResponse("Myopic insects meet");
        assertThat(actual, nullValue());
    }
}
