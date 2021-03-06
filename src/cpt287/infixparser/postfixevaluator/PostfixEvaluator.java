package cpt287.infixparser.postfixevaluator;

import cpt287.infixparser.handleOneOperation.HandleOneOperation;
import java.util.*;

public class PostfixEvaluator {
    private HandleOneOperation handleOneOperation = new HandleOneOperation();

    public Integer evaluatePostfix(String postFix) throws ArithmeticException{

        Queue<String> postFixQueue = new LinkedList<String>();

        List<String> postFixList = Arrays.asList(postFix.split(" "));

        // for loop clean up white spaces
        for(String item : postFixList){
            postFixQueue.offer(item.trim());
        }

        System.out.println("PostfixQueue: " + postFixQueue);

        Stack<String> tempStack = new Stack<>();
        // stack to handle postfix
        while (!postFixQueue.isEmpty()){
            if(postFixQueue.peek().charAt(0) >= '0' && postFixQueue.peek().charAt(0) <='9'){
                // number
                tempStack.push(postFixQueue.poll());
            } else {
                // is an operator
                Integer rightVal = Integer.parseInt(tempStack.pop());
                Integer leftVal = Integer.parseInt(tempStack.pop());
                String operator = postFixQueue.poll();
                // divide by zero found
                if (rightVal == 0 && operator.compareTo("/") == 0){
                    throw new ArithmeticException("Divide by zero not allowed, evaluation of expression cancelled.");
                }
                Integer result = handleOneOperation.handleOneOperation(leftVal,rightVal,operator);

                tempStack.push(result.toString());
            }
        }
        return Integer.parseInt(tempStack.pop());
    }
}
