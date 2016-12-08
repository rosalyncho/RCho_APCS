package fracCalc;

import java.util.Scanner;

public class FracCalcCheckpoint3 {

	    public static void main(String[] args) 
	    {
	        // TODO: Read the input from the user and call produceAnswer with an equation
	    	Scanner console = new Scanner(System.in);
	    	System.out.println("Enter your operation.");
	    	String input = console.nextLine();
	    	while (input.equals("quit")){
	    		String answer = produceAnswer(input);
	    		System.out.println(answer);
	    	}
	    	System.out.println(produceAnswer(input));
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
	    	
	    	String[] operator=parseInput(input);
			int[] firstOperand=parseFractions(operator[0]); // index 0 is first operand
															 // index 1 is the operator
			int[] secondOperand=parseFractions(operator[2]); // index 2 is second operand
			int[] answer = new int [2];
	        if (operator[1].equals("+")) // if the operator is positive
	        	answer = addFrac(firstOperand,secondOperand);
	        else if(operator[1].equals("-")) // if the operator is negative
	        	answer = subtractFrac(firstOperand,secondOperand);
	        else if(operator[1].equals("*")) // if the operator is multiplication
	        	answer = multiplyFrac(firstOperand,secondOperand);
	        else if(operator[1].equals("/")) // if the operator is division
	        	answer = divideFrac(firstOperand,secondOperand);
	        return toMixedNum(answer);
	    }

	    // TODO: Fill in the space below with any helper methods that you think you will need
	    
	    public static String[] parseInput(String input)
	    {
	    	String[] answer=input.split(" "); 
			return answer;
	    }
	    
	    public static int[] parseFractions(String operand)
	    {
	    	int[] answer = new int[3];
	    	
	    	int operandLength = operand.length();
	    	if (operand.indexOf("_")==-1 && operand.indexOf("/")==-1) { // if the value is a whole number
	    		answer[0] = Integer.parseInt(operand);
	    		answer[1] = 0;
	    	    answer[2] = 1;
	    	} else if (operand.indexOf("_")==-1) { // if the value is a fraction
	    		answer[0] = 0;
	    		answer[1] = Integer.parseInt(operand.substring(0, operand.indexOf("/")));
	    		answer[2] = Integer.parseInt(operand.substring(operand.indexOf("/") + 1, operandLength));
	    	} else { // if the value is a mixed number
	    		answer[0] = Integer.parseInt(operand.substring(0,operand.indexOf("_")));
	    		answer[1] = Integer.parseInt(operand.substring(operand.indexOf("_")+1,operand.indexOf("/")));
	    		answer[2] = Integer.parseInt(operand.substring(operand.indexOf("/")+1));
	    	}
	    	return toImproperFrac(answer);
	    	
	    }
	    
	 // converts mixed number into an improper fraction
	    public static int[] toImproperFrac (int[] operand) {
	    	if(operand[0] == 0){ // if the operand is 0
	    		operand[0] = operand[1];
	    	}else if(operand[0] < 0){ // if the operand is negative
	    		operand[0] = operand[0] * operand[2] - operand[1];
	    	}else{ // if the operand is positive
	    		operand[0] = operand[0] * operand[2] + operand[1];
	    	}
	    	operand[1] = operand[2]; // denominator
	    	
	    	return operand;
		}
	    
	    // addition
	    public static int[] addFrac(int[] firstOperand, int[] secondOperand)
	    {
	    	int[] answer = new int[2];
	    	
	    	if(firstOperand[1] == secondOperand[1]){ // if the fractions have the same denominators
	    		answer[0] = firstOperand[0] + secondOperand[0];
	    		answer[1] = firstOperand[1];
	    	}else{ // if the fractions have different denominators
	    		firstOperand[0] = firstOperand[0] * secondOperand[1];
	    		secondOperand[0] = secondOperand[0] * firstOperand[1];
	    		answer[0] = firstOperand[0] + secondOperand[0];
	    		answer[1] = firstOperand[1] * secondOperand[1];
	    	}
			return answer;
	    }
	    
	    // subtraction
	    public static int[] subtractFrac(int[] firstOperand, int[] secondOperand)
	    {
	    	secondOperand[0]=secondOperand[0]*-1; // multiply -1 to the numerator of the second operand
			return addFrac(firstOperand, secondOperand); // passes to addition
	    }
	    
	    // multiplication
	    public static int[] multiplyFrac(int[] firstOperand, int[] secondOperand)
	    {
	    	int[] answer = new int[2];
			answer[0]= firstOperand[0]*secondOperand[0];
			answer[1] = firstOperand[1]*secondOperand[1];
			return answer;
	    }
	    
	    // division
	    public static int[] divideFrac(int[] firstOperand, int[] secondOperand)
	    {
	    	int[] answer = new int[2];
			answer[0]=secondOperand[1]; // flips the second operand's numerator and denominator
			answer[1]=secondOperand[0];
			return multiplyFrac(firstOperand, answer); // passes to multiplication
	    }
	    
	    // converts improper fraction to mixed number for the final answer
	    public static String toMixedNum(int[] operand){
	    	int wholeNumber = operand[0] / operand[1];
	    	int numerator = operand[0] % operand[1];
	    	int denominator = operand[1];
	    	if(numerator < 0){
	    		numerator *= -1;
	    	}
	    	if(denominator < 0){
	    		denominator *= -1;
	    	}
	    	return (wholeNumber + "_" + numerator + "/" + denominator);
	    }
}
