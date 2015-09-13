package com.swigder.nlp.eliza;

import java.util.Scanner;

/**
 * Eliza conducts a conversation with a user using a configured ResponseGenerator.
 */
public class Eliza {

    private final InputHandler inputHandler;

    public Eliza(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello.");

        while (true) {
            String input = scanner.nextLine();
            System.out.println(inputHandler.handleInput(input));
        }
    }

}
