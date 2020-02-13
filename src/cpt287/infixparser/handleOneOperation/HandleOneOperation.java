package cpt287.infixparser.handleOneOperation;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class HandleOneOperation {

    //TODO: Complete this;
    public Integer handleOneOperation(Integer leftVal, Integer rightVal, String oper){
        Integer leftInt = leftVal;
        Integer rightInt = rightVal;
        String operator = oper;

        List<String> operators = Arrays.asList("+","-","*","/","^","%",">","<",">=","<=","==","!=", "||", "&&");


        Integer result = -1;

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
           result = (int)Math.pow(leftInt,rightInt);
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
