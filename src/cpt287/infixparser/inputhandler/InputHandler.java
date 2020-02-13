package cpt287.infixparser.inputhandler;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);

    public Queue<Character> getUserInput() {

        System.out.println("Please enter an equation to evaluate: ");
        // get user input
        String equationString = scanner.nextLine();
        // remove white space
        equationString = equationString.replaceAll(" ", "");

        // Queue to store user input characters
        Queue<Character> inputQueue = new LinkedList<Character>();

        // add characters from input string to Queue
        for(int i = 0; i < equationString.length(); i++){
            inputQueue.offer(equationString.charAt(i));
        }
        return inputQueue;
    }
}