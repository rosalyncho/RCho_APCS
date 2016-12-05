package fracCalc;

import java.util.Scanner;

public class FracCalcCheckpoint2 {

	public static void main(String[] args) 
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Enter your operation.");
		String input = console.nextLine();
		while (!input.equals("quit")) {
			System.out.println(produceAnswer(input));
			input = console.nextLine();
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
	    	String[] splitString = input.split(" ");
	    	String firstOperand = splitString[0];
	    	String operator = splitString[1];
	    	String secondOperand = splitString[2];
	        
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
