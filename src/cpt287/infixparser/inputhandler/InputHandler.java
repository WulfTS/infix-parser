package cpt287.infixparser.inputhandler;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);

    public List<String> getUserInput() {

        System.out.println("Please enter an equation to evaluate: ");

                String equationString = scanner.nextLine();
                equationString.replaceAll("\\s+","");

                String number = "";

                String comparisonString = "";

                List<Character> operators = Arrays.asList('+','-','*','/','%','^','(','[',')',']');

                List<Character>  comparisons = Arrays.asList('=','>','<','!','|');

                List<String> formula = Arrays.asList();

                System.out.println("EquationString : " + equationString);

        for (int i = 0; i < equationString.length(); i++) {
            System.out.println("Character : " + equationString.charAt(i));
            if(equationString.charAt(i) >= '0' && equationString.charAt(i) <= '9'){
                number = number + equationString.charAt(i);
            } else if(operators.contains(equationString.charAt(i))) {
                formula.add(number);
                number = "";
                formula.add(Character.toString(equationString.charAt(i)));
            } else if(comparisons.contains(equationString.charAt(i)) && comparisons.contains(equationString.charAt(i + 1))){
                formula.add(number);
                number = "";
                comparisonString = comparisonString + equationString.charAt(i) + equationString.charAt(i+1);
                formula.add(comparisonString);
                comparisonString = "";
            }
        }
        if(number != ""){
            formula.add(number);
        }

        return formula;
    }
}
