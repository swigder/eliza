package com.swigder.nlp.eliza.prompter;

/**
 * Provides a prompt to display to the user without depending on user input.
 * For example, can be implemented by classes that initially prompt the user
 * when the app is first launched, prompt the user when s/he is idle for a while,
 * and so on.
 */
public interface Prompter {
    /**
     * Provides an prompt to display to the user
     * @return String prompt to display to the user
     */
    public String prompt();
}
