package com.swigder.nlp.eliza.transformer.input;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrimmingTransformerTest {
    TrimmingTransformer transformer = new TrimmingTransformer();

    @Test
    public void trims() {
        String actual = transformer.transform("  I like to move it move it  \t   \n   ");
        assertThat(actual, is("I like to move it move it"));
    }
}
