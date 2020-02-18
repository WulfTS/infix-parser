package cpt287.infixparser.inputhandler;

import java.io.*;
import java.util.*;

public class InputHandler {

    public  Scanner scanner = new Scanner(System.in);
    private List<Character> validCharacters = Arrays.asList('+','-','*','/','^','%','(',')','[',']','=','>','<','|','!','&');
    //uses buffered reader to get expressions from input file and store them in a list of queues of strings
    public List<Queue<String>> getInputFromTextFile() throws IOException {
        ArrayList<Queue<String>> qStr = new ArrayList<Queue<String>>();

        File file = new File("input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        // while loop that adds expressions to queue until empty line
        while ((st = br.readLine()) != null){
            qStr.add(stringToQueue(st));
        }
        return qStr;
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
                // data validation for letters, exits if found, takes precedence over divide by zero
            } else {
                System.out.println("You entered an invalid expression to evaluate.  \n" +
                        "Please correct the input file and do not include any letter variables.");
                System.exit(-1);
            }
        }
        if(number != ""){
            outputQueue.offer(number);
        }
        return outputQueue;
    }
}