package cpt287.infixparser;

import cpt287.infixparser.handleOneOperation.HandleOneOperation;
import cpt287.infixparser.infixtopostfix.InfixToPostfixConverter;
import cpt287.infixparser.inputhandler.InputHandler;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        InputHandler inputHandler = new InputHandler();
        HandleOneOperation handleOneOperation = new HandleOneOperation();
        InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();

        Queue<String> userInputResult = inputHandler.getUserInput();

        System.out.println(userInputResult);

        System.out.println("Postfix string: " + infixToPostfixConverter.convertInfixToPostfix(userInputResult));
    }
}
