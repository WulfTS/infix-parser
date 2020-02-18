package cpt287.infixparser.inputhandler;

import java.io.*;
import java.util.*;

public class InputHandler {

    public  Scanner scanner = new Scanner(System.in);
    private List<Character> validCharacters = Arrays.asList('+','-','*','/','^','%','(',')','[',']','=','>','<','|','!','&');

    public List<Queue<String>> getInputFromTextFile() throws IOException {
        ArrayList<Queue<String>> qStr = new ArrayList<Queue<String>>();

        File file = new File("input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null){
            qStr.add(stringToQueue(st));
        }
        return qStr;
    }
    public Queue<String> getUserInput() {

        System.out.println("Please enter an expression to evaluate: ");
        // get user input
        String equationString = scanner.nextLine();

        return stringToQueue(equationString);
    }

    private Queue<String> stringToQueue(String inputString){
        // create new outputQueue every time method is called for multiple expressions in text file
        Queue<String> outputQueue= new LinkedList<String>();
        // remove white space
        inputString = inputString.replaceAll(" ","");

        // Queue to store user input characters
        Queue<Character> inputQueue = new LinkedList<Character>();

        // add characters from input string to Queue
        for(int i = 0; i < inputString.length(); i++){
            inputQueue.offer(inputString.charAt(i));
        }

        // generate output queue consisting of numbers, operators, and parenthesis
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