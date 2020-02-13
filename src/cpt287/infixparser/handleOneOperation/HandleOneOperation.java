package cpt287.infixparser.handleOneOperation;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class HandleOneOperation {

    //TODO: Complete this;
    public double handleOneOperation(Queue<String> userInputQueue){
        Integer leftInt = null;
        Integer rightInt = null;
        String operator = null;
        String comparator = null;

        List<String> operators = Arrays.asList("+","-","*","/","^","%",">","<",">=","<=","==","!=", "||");


        double result = -1;

       if(userInputQueue.peek().charAt(0) >='0' && userInputQueue.peek().charAt(0) <='9'){
           leftInt = Integer.parseInt(userInputQueue.poll());
       }

       if(operators.contains(userInputQueue.peek()) ){
           operator = userInputQueue.poll();
       }

       if(userInputQueue.peek().charAt(0) >='0' && userInputQueue.peek().charAt(0) <='9'){
            rightInt = Integer.parseInt(userInputQueue.poll());
       }

       // perform operations
       if(operator.equals("+")) {
           result = leftInt + rightInt;
       } else if (operator.equals("-")){
           result = leftInt - rightInt;
       } else if (operator.equals("*")){
           result = leftInt * rightInt;
       } else if (operator.equals("/")){
           result = leftInt / rightInt;
       } else if (operator.equals("^")){
           result = Math.pow(leftInt,rightInt);
       } else if (operator.equals("%")){
           result = leftInt % rightInt;
       } else if (operator.equals(">")){
           if(leftInt > rightInt){
               result = 1;
           } else {
               result = 0;
           }
       } else if (operator.equals("<")){
           if(leftInt < rightInt){
               result = 1;
           } else {
               result = 0;
           }
       }else if (operator.equals(">=")){
           if(leftInt > rightInt){
               result = 1;
           } else {
               result = 0;
           }
       } else if (operator.equals("<=")){
           if(leftInt < rightInt){
               result = 1;
           } else {
               result = 0;
           }
       }else if (operator.equals("==")){
           if(leftInt == rightInt){
               result = 1;
           } else {
               result = 0;
           }
       }else if (operator.equals("!=")){
           if(leftInt != rightInt){
               result = 1;
           } else {
               result = 0;
           }
       }

        return result;
    }
}
