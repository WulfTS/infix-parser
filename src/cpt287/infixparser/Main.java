package cpt287.infixparser;

import cpt287.infixparser.inputhandler.InputHandler;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        InputHandler inputHandler = new InputHandler();

        Queue<String> userInputResult = inputHandler.getUserInput();

        System.out.println(userInputResult);

    }
}
