package cpt287.infixparser.infixtopostfix;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class InfixToPostfixConverter {
    /**
     *
     * @param current
     * @param top
     * @return true if precedence of current <= top
     */
    //TODO: Complete me.
    private boolean precedence(String current, String top){
        if(top.equals("^")){
            return true;
        } else if (top.equals("*") || top.equals("/")|| top.equals("%")){
            if(current.equals("^")){
                return false;
            } else return true;
        } else if (top.equals("+") || top.equals("-")){
            if(current.equals("^") || current.equals("*") || current.equals("/") || current.equals("%")){
                return false;
            } else {
                return true;
            }
        }

    }



    // TODO: Complete me
    public String convertInfixToPostfix(Queue<String> userInputQueue){
        String postfixString = "";

        Stack<String> tempStack = new Stack<>();
        List<String> operators = Arrays.asList("+","-","*","/","^","%",">","<",">=","<=","==","!=", "||");

        while(userInputQueue.size() > 0) {
            if (userInputQueue.peek().charAt(0) >= '0' && userInputQueue.peek().charAt(0) <= '9') {
                postfixString = postfixString + userInputQueue.poll();
            } else if (userInputQueue.peek().equals("(")){
                tempStack.push(userInputQueue.poll());
            } else if (operators.contains(userInputQueue.peek())){
                while (!userInputQueue.isEmpty() && !userInputQueue.peek().equals("(") && precedence(userInputQueue.peek(),tempStack.peek())){
                }
            }
        }

        return postfixString;
    }

}
