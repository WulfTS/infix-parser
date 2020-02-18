package cpt287.infixparser;

import cpt287.infixparser.infixtopostfix.InfixToPostfixConverter;
import cpt287.infixparser.inputhandler.InputHandler;
import cpt287.infixparser.postfixevaluator.PostfixEvaluator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        // open new classes
        InputHandler inputHandler = new InputHandler();
        InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();
        PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
        // put expressions from an input file in a queue
        List<Queue<String>> qStr = inputHandler.getInputFromTextFile();

        // iterates over queue to process each expression
        for (Queue<String> strings : qStr) {
            System.out.println("\n" + strings);

            String postfixString = infixToPostfixConverter.convertInfixToPostfix(strings);

            System.out.println("Postfix string: " + postfixString);
            // catch divide by zero
            try {
                System.out.println("Result: " + postfixEvaluator.evaluatePostfix(postfixString));
            } catch (ArithmeticException e) {
                System.out.println("Unable to parse expression: " + e.getMessage());
            }
        }

        inputHandler.scanner.close();

    }
}
