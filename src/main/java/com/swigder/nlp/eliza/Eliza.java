package com.swigder.nlp.eliza;

import com.swigder.nlp.eliza.prompter.Prompter;

import java.util.Scanner;

/**
 * Eliza conducts a conversation with a user using a configured ResponseGenerator.
 */
public class Eliza {

    private final Prompter initialPrompter;
    private final InputHandler inputHandler;

    public Eliza(Prompter initialPrompter, InputHandler inputHandler) {
        this.initialPrompter = initialPrompter;
        this.inputHandler = inputHandler;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(initialPrompter.prompt());

        while (true) {
            String input = scanner.nextLine();
            System.out.println(inputHandler.handleInput(input));
        }
    }

}
