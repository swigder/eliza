package com.swigder.nlp.eliza.responder.impl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class FeelingResponseGeneratorTest {
    FeelingResponseGenerator generator = new FeelingResponseGenerator();

    @Test
    public void iXMyY() {
        String actual = generator.generateResponse("I hate my mother-in-law");
        assertThat(actual, anyOf(equalTo("Why do you hate your mother-in-law?")));
    }

    @Test
    public void imSad() {
        String actual = generator.generateResponse("I'm sad");
        assertThat(actual, anyOf(equalTo("I am sorry that you are sad."), equalTo("Since when have you been feeling sad?"), equalTo("Why are you feeling sad?")));
    }

    @Test
    public void iAmSad() {
        String actual = generator.generateResponse("I am sad");
        assertThat(actual, anyOf(equalTo("I am sorry that you are sad."), equalTo("Since when have you been feeling sad?"), equalTo("Why are you feeling sad?")));
    }

    @Test
    public void imFeelingSad() {
        String actual = generator.generateResponse("I'm feeling sad");
        assertThat(actual, anyOf(equalTo("I am sorry that you are sad."), equalTo("Since when have you been feeling sad?"), equalTo("Why are you feeling sad?")));
    }

    @Test
    public void iAmFeelingSad() {
        String actual = generator.generateResponse("I am feeling sad");
        assertThat(actual, anyOf(equalTo("I am sorry that you are sad."), equalTo("Since when have you been feeling sad?"), equalTo("Why are you feeling sad?")));
    }

    @Test
    public void iFeelSad() {
        String actual = generator.generateResponse("I am feeling sad");
        assertThat(actual, anyOf(equalTo("I am sorry that you are sad."), equalTo("Since when have you been feeling sad?"), equalTo("Why are you feeling sad?")));
    }

    @Test
    public void imHappy() {
        String actual = generator.generateResponse("I'm happy");
        assertThat(actual, anyOf(equalTo("I am glad that you are happy.")));
    }

    @Test
    public void iAmHappy() {
        String actual = generator.generateResponse("I am happy");
        assertThat(actual, anyOf(equalTo("I am glad that you are happy.")));
    }

    @Test
    public void iFeelHappy() {
        String actual = generator.generateResponse("I feel happy");
        assertThat(actual, anyOf(equalTo("I am glad that you are happy.")));
    }

    @Test
    public void iAmFeelingHappy() {
        String actual = generator.generateResponse("I am feeling happy");
        assertThat(actual, anyOf(equalTo("I am glad that you are happy.")));
    }

    @Test
    public void iveBeenFeelingHappy() {
        String actual = generator.generateResponse("I've been feeling happy");
        assertThat(actual, anyOf(equalTo("I am glad that you are happy.")));
    }

    @Test
    public void iFeelX() {
        String actual = generator.generateResponse("I feel like a flying demon");
        assertThat(actual, anyOf(equalTo("Why do you feel that way?"), equalTo("Tell me more about that feeling.")));
    }

    @Test
    public void iAmX() {
        String actual = generator.generateResponse("I am tired");
        assertThat(actual, anyOf(equalTo("Why are you tired?"), equalTo("Do you think it is good that you are tired?")));
    }

    @Test
    public void imX() {
        String actual = generator.generateResponse("I'm tired");
        assertThat(actual, anyOf(equalTo("Why are you tired?"), equalTo("Do you think it is good that you are tired?")));
    }

    @Test
    public void imALittleX() {
        String actual = generator.generateResponse("I'm a little tired");
        assertThat(actual, anyOf(equalTo("Why are you tired?"), equalTo("Do you think it is good that you are tired?")));
    }

    @Test
    public void imSomeString() {
        String actual = generator.generateResponse("I'm just that kind of girl");
        assertThat(actual, anyOf(equalTo("Why are you just that kind of girl?")));
    }

    @Test
    public void iAmSomeString() {
        String actual = generator.generateResponse("I am just that kind of girl");
        assertThat(actual, anyOf(equalTo("Why are you just that kind of girl?")));
    }

    @Test
    public void imQuiteSomeString() {
        String actual = generator.generateResponse("I'm quite afraid of animals");
        assertThat(actual, anyOf(equalTo("Why are you afraid of animals?")));
    }

    @Test
    public void iThinkX() {
        String actual = generator.generateResponse("I think I am a cat");
        assertThat(actual, anyOf(equalTo("Why do you think that?")));
    }

    @Test
    public void myLifeSucks() {
        String actual = generator.generateResponse("My life sucks");
        assertThat(actual, anyOf(equalTo("Why does your life suck?")));
    }

    @Test
    public void myLifeStrings() {
        String actual = generator.generateResponse("My life is a bowl of strawberries and cream");
        assertThat(actual, anyOf(equalTo("Tell me more about that.")));
    }

    @Test
    public void bad() {
        String actual = generator.generateResponse("Everything is bad");
        assertThat(actual, anyOf(equalTo("I'm sorry about that.")));
    }

}
