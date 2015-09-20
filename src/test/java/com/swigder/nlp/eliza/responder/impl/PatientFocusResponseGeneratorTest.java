package com.swigder.nlp.eliza.responder.impl;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PatientFocusResponseGeneratorTest {
    PatientFocusResponseGenerator generator = new PatientFocusResponseGenerator();

    @Test
    public void you() {
        String actual = generator.generateResponse("you");
        assertThat(actual, anyOf(equalTo("Let's talk about you today, okay?")));
    }

    @Test
    public void youMulticase() {
        String actual = generator.generateResponse("YoU");
        assertThat(actual, anyOf(equalTo("Let's talk about you today, okay?")));
    }

    @Test
    public void youMidSentence() {
        String actual = generator.generateResponse("What about you");
        assertThat(actual, anyOf(equalTo("Let's talk about you today, okay?")));
    }

    @Test
    public void yourself() {
        String actual = generator.generateResponse("Go fuck yourself");
        assertThat(actual, anyOf(equalTo("Let's talk about you today, okay?")));
    }

}
