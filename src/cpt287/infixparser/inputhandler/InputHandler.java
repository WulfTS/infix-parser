package cpt287.infixparser.inputhandler;

import java.util.*;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);

    Queue<String> outputQueue= new LinkedList<String>();

    List<Character> validCharacters = Arrays.asList('+','-','*','/','^','%','(',')','[',']','=','>','<','|','!');

    public Queue<String> getUserInput() {

        System.out.println("Please enter an expression to evaluate: ");
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

        // generate output queue consisting of numbers & operators
        String number = "";
        String operator = "";
        while (!inputQueue.isEmpty()){
            Character value = inputQueue.poll();

            if(value >= '0' && value <='9'){
                number = number + value;
                if(!operator.equals("")){
                    outputQueue.offer(operator);
                    operator = "";
                }
            } else if(validCharacters.contains(value)) {
                if(number != ""){
                    outputQueue.offer(number);
                    number = "";
                }
                if(value.equals('(') || value.equals('[') || value.equals(')') || value.equals(']')){
                    if(!operator.equals("")) {
                        outputQueue.offer(operator);
                        operator = "";
                    }
                    outputQueue.offer(Character.toString(value));
                } else {
                    operator = operator + value;
                }
            } else {
                System.out.println("You entered an invalid expression to evaluate.  \n" +
                        "Please try again and do not include any letter variables.");
                getUserInput();
            }
        }
        if(number != ""){
            outputQueue.offer(number);
        }
        return outputQueue;
    }
}