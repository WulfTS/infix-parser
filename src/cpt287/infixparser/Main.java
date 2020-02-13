package cpt287.infixparser;

import cpt287.infixparser.handleOneOperation.HandleOneOperation;
import cpt287.infixparser.infixtopostfix.InfixToPostfixConverter;
import cpt287.infixparser.inputhandler.InputHandler;
import cpt287.infixparser.postfixevaluator.PostfixEvaluator;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        InputHandler inputHandler = new InputHandler();
        HandleOneOperation handleOneOperation = new HandleOneOperation();
        InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();
        PostfixEvaluator postfixEvaluator = new PostfixEvaluator();

        Queue<String> userInputResult = inputHandler.getUserInput();

        System.out.println(userInputResult);

        String postfixString = infixToPostfixConverter.convertInfixToPostfix(userInputResult);

        System.out.println("Postfix string: " + postfixString);

        System.out.println("Result: " + postfixEvaluator.evaluatePostfix(postfixString));

    }
}
