
package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner console = new Scanner(System.in);
    	System.out.println("Enter your operation.");
    	String input = console.nextLine();
    	if (input.equals("quit")){
    		String answer=produceAnswer(input);
    		System.out.println(answer);
    	}
    	produceAnswer(input);
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String firstOperand = new String();
    	String operator = new String();
    	String secondOperand = new String();
    	int lengthOfInput = input.length(); 
    	int firstSpace = input.indexOf(" ");
    	int secondSpace = input.indexOf(" ", firstSpace + 2);
    	operator = input.substring(firstSpace+1, secondSpace);
    	firstOperand = input.substring(0, firstSpace);
    	secondOperand = input.substring(secondSpace+1, lengthOfInput);
    	
        return parseFractions(secondOperand);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String parseFractions(String secondOperand)
    {
    	String wholeNumber = "0";
    	String numerator = "0";
    	String denominator = "0";
    	int secondOperandLength = secondOperand.length();
    	if (secondOperand.indexOf("_")==-1 && secondOperand.indexOf("/")==-1) { // if the value is a whole number
    		wholeNumber = secondOperand;
    		numerator = "0";
    		denominator = "1";
    	} else if (secondOperand.indexOf("_")==-1) { // if the value is a fraction
    		wholeNumber = "0";
    		numerator = secondOperand.substring(0, secondOperand.indexOf("/"));
    		denominator = secondOperand.substring(secondOperand.indexOf("/") + 1, secondOperandLength);
    	} else { // if the value is a mixed number
    		wholeNumber = secondOperand.substring(0, secondOperand.indexOf("_"));
    		numerator = secondOperand.substring(secondOperand.indexOf("_") + 1, secondOperand.indexOf("/")); 
    		denominator = secondOperand.substring(secondOperand.indexOf("/") + 1, secondOperandLength);
    	}
    	
    	return ("whole:" + wholeNumber + " numerator:" + numerator + " denominator:" + denominator);
    }
}
