package cpt287.infixparser.infixtopostfix;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class InfixToPostfixConverter {
    /**
     * @param current String operator
     * @param top operator at top of temp stack to compare current operator to
     * @return true if precedence of current <= top
     */
    //TODO: Check to see if I work.
    private boolean precedence(String current, String top) {
        if (top.equals("^")) {
            return true;
        } else if (top.equals("*") || top.equals("/") || top.equals("%")) {
            if (current.equals("^")) {
                return false;
            } else return true;
        } else if (top.equals("+") || top.equals("-")) {
            if (current.equals("^")
                    || current.equals("*")
                    || current.equals("/")
                    || current.equals("%")) {
                return false;
            } else {
                return true;
            }
        } else if (top.equals(">") || top.equals("<") || top.equals(">=") || top.equals("<=")) {
            if (current.equals("^")
                    || current.equals("*")
                    || current.equals("/")
                    || current.equals("%")
                    || current.equals("+")
                    || current.equals("-")) {
                return false;
            } else {
                return true;
            }
        } else if (top.equals("==") || top.equals("!=")) {
            if (current.equals("^")
                    || current.equals("*")
                    || current.equals("/")
                    || current.equals("%")
                    || current.equals("+")
                    || current.equals("-")
                    || current.equals(">")
                    || current.equals("<")
                    || current.equals(">=")
                    || current.equals("<=")) {
                return false;
            } else {
                return true;
            }

        } else if (top.equals("&&")) {
            if (current.equals("^")
                    || current.equals("*")
                    || current.equals("/")
                    || current.equals("%")
                    || current.equals("+")
                    || current.equals("-")
                    || current.equals(">")
                    || current.equals("<")
                    || current.equals(">=")
                    || current.equals("<=")
                    || current.equals("==")
                    || current.equals("!=")) {
                return false;
            } else {
                return true;
            }
        } else if (top.equals("||")) {
            if (current.equals("||")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    // TODO: Complete me & fix the problem I'm having with parenthesis;
    public String convertInfixToPostfix(Queue<String> userInputQueue){
        String postfixString = "";

        Stack<String> tempStack = new Stack<>();
        List<String> operators = Arrays.asList("+","-","*","/","^","%",">","<",">=","<=","==","!=", "||", "&&");

        while(!userInputQueue.isEmpty()) {
            if (userInputQueue.peek().charAt(0) >= '0' && userInputQueue.peek().charAt(0) <= '9') {
                postfixString = postfixString + userInputQueue.poll();
                postfixString = postfixString + " ";
            } else if (userInputQueue.peek().equals("(")){
                tempStack.push(userInputQueue.poll());
            } else if (operators.contains(userInputQueue.peek())){
                while (!tempStack.isEmpty() && !tempStack.peek().equals("(") && precedence(userInputQueue.peek(),tempStack.peek())){
                    postfixString = postfixString + tempStack.pop() + " ";
                }
                tempStack.push(userInputQueue.poll());
            } else{
                while (!tempStack.peek().equals("(")){
                    postfixString = postfixString + tempStack.pop() + " ";
                }
                tempStack.pop();
            }
        }
        while (!tempStack.isEmpty()){
            postfixString = postfixString + tempStack.pop() + " ";
        }
        return postfixString;
    }

}
