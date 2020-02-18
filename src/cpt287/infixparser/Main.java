package cpt287.infixparser;

import cpt287.infixparser.handleOneOperation.HandleOneOperation;
import cpt287.infixparser.infixtopostfix.InfixToPostfixConverter;
import cpt287.infixparser.inputhandler.InputHandler;
import cpt287.infixparser.postfixevaluator.PostfixEvaluator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
// TODO: Add Comments & general code cleanup & refactoring
// TODO: Double check that everything is working correctly
public class Main {

    public static void main(String[] args) throws IOException {
        InputHandler inputHandler = new InputHandler();
        InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();
        PostfixEvaluator postfixEvaluator = new PostfixEvaluator();

        List<Queue<String>> qStr = inputHandler.getInputFromTextFile();

        for (Queue<String> strings : qStr) {
            System.out.println("\n" + strings);

            String postfixString = infixToPostfixConverter.convertInfixToPostfix(strings);

            System.out.println("Postfix string: " + postfixString);

            try {
                System.out.println("Result: " + postfixEvaluator.evaluatePostfix(postfixString));
            } catch (ArithmeticException e) {
                System.out.println("Unable to parse expression: " + e.getMessage());
            }
        }



    }
}
