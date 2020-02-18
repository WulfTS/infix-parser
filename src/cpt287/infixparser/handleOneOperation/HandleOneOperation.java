package cpt287.infixparser.handleOneOperation;

public class HandleOneOperation {
    // handles operands and operator
    public Integer handleOneOperation(Integer leftVal, Integer rightVal, String oper){
        Integer leftInt = leftVal;
        Integer rightInt = rightVal;
        String operator = oper;

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
       }else if (operator.equals("&&")){
           if(leftInt != 0 && rightInt != 0){
               result = 1;
           } else {
               result = 0;          
           }
       }else if (operator.equals("||")){
            if(leftInt != 0 || rightInt != 0){
               result = 1;
           } else {
               result = 0;
           }
       }
       // return the result
        return result;
    }
}
