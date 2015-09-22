package com.swigder.nlp.eliza;

import com.swigder.nlp.eliza.prompter.Prompter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Eliza conducts a conversation with a user using configured prompters
 * and generators.
 */
public class Eliza {

    private final InputStream inputStream;
    private final PrintStream outputStream;
    private final Prompter initialPrompter;
    private final InputHandler inputHandler;

    public Eliza(InputStream inputStream, PrintStream outputStream, Prompter initialPrompter, InputHandler inputHandler) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.initialPrompter = initialPrompter;
        this.inputHandler = inputHandler;
    }

    public void run() {
        Scanner scanner = new Scanner(inputStream);

        outputStream.println(initialPrompter.prompt()); // todo this separation of initial prompter is a bit weird and also means transformers aren't run on it

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            outputStream.println(inputHandler.handleInput(input));
        }
    }

}
