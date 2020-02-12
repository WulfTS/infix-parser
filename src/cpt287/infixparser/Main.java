package cpt287.infixparser;

import cpt287.infixparser.inputhandler.InputHandler;

public class Main {

    public static void main(String[] args) {
	// write your code here
        InputHandler inputHandler = new InputHandler();

        System.out.println(inputHandler.getUserInput());
    }
}
