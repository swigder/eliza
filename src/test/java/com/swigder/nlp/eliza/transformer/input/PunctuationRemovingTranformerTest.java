package com.swigder.nlp.eliza.transformer.input;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PunctuationRemovingTranformerTest {
    PunctuationRemovingTranformer tranformer = new PunctuationRemovingTranformer();

    @Test
    public void removesTerminalPunctuation() {
        String actual = tranformer.transform("Sam I am.");
        assertThat(actual, is("Sam I am"));
    }

    @Test
    public void removesRepeatedPunctuation() {
        String actual = tranformer.transform("Who is Sam???!!??");
        assertThat(actual, is("Who is Sam"));
    }

    @Test
    public void doesntRemoveNonTerminalPunctuation() {
        String actual = tranformer.transform("Sam is Mr. Samson's father");
        assertThat(actual, is("Sam is Mr. Samson's father"));
    }

    @Test
    public void removesCommasWhereeverTheyMayBe() {
        String actual = tranformer.transform("Sam, my friend, is cool");
        assertThat(actual, is("Sam my friend is cool"));
    }
}
