package cpt287.infixparser.postfixevaluator;

import cpt287.infixparser.handleOneOperation.HandleOneOperation;

import java.util.*;

public class PostfixEvaluator {
    HandleOneOperation handleOneOperation = new HandleOneOperation();

    public Integer evaluatePostfix(String postFix){

        Queue<String> postFixQueue = new LinkedList<String>();

        List<String> postFixList = Arrays.asList(postFix.split(" "));

        for(String item : postFixList){
            postFixQueue.offer(item.trim());
        }

        System.out.println("PostfixQueue: " + postFixQueue);

        Stack<String> tempStack = new Stack<>();

        while (!postFixQueue.isEmpty()){
            if(postFixQueue.peek().charAt(0) >= '0' && postFixQueue.peek().charAt(0) <='9'){
                // number
                tempStack.push(postFixQueue.poll());
            } else {
                // is an operator
                Integer rightVal = Integer.parseInt(tempStack.pop());
                Integer leftVal = Integer.parseInt(tempStack.pop());
                String operator = postFixQueue.poll();

                Integer result = handleOneOperation.handleOneOperation(leftVal,rightVal,operator);

                tempStack.push(result.toString());
            }
        }
        return Integer.parseInt(tempStack.pop());
    }
}
