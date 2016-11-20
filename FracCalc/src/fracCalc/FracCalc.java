
package fracCalc;

import java.util.Arrays;
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
    	String[] splitted = input.split(" "); //parses by spaces
    	int lengthOfInput = input.length(); 
  //    System.out.println(Arrays.toString(splitted));
    	int firstSpace = input.indexOf(" ");
    	int secondSpace = input.indexOf(" ", firstSpace + 2);
    	operator = input.substring(firstSpace+1, secondSpace);
  //  	String firstOperand = input.substring(firstSpace, secondSpace);
  //  	System.out.println(operator);
    	firstOperand = input.substring(0, firstSpace);
  //  	System.out.println(firstOperand);
    	secondOperand = input.substring(secondSpace+1, lengthOfInput);
   // 	System.out.println(secondOperand);
    	
        return parseFractions(secondOperand);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String parseFractions(String secondOperand)
    {
  //  	if (secondOperand.indexOf("_")==-1 && secondOperand.indexOf("/")==-1) {
    		String wholeNumber = secondOperand.substring(0, secondOperand.indexOf("_"));
    		String numerator = secondOperand.substring(secondOperand.indexOf("_") + 1, secondOperand.indexOf("/")); //gets the value starting from position 0 to the "_"
    		String denominator = secondOperand.substring(secondOperand.indexOf("/") + 1, secondOperand.length());
    		return ("whole:" + wholeNumber + " numerator:" + numerator + " denominator:" + denominator);
    }
}
