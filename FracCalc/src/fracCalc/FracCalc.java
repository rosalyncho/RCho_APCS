// Rosalyn Cho
// FracCalc Checkpoint 3
// 12/4/2016

package fracCalc;

import java.util.Scanner;

public class FracCalc {

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
        return simplify(toMixedNum(answer));
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
		answer[0]= firstOperand[0]*secondOperand[0]; // multiply the numerators
		answer[1] = firstOperand[1]*secondOperand[1]; // multiply the denominators
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
    public static int[] toMixedNum(int[] improperFrac){
    	int[] mixedNumber = new int[3];
    	mixedNumber[0] = improperFrac[0] / improperFrac[1]; // whole number
    	mixedNumber[1] = improperFrac[0] % improperFrac[1]; // numerator
    	mixedNumber[2] = improperFrac[1]; // denominator
    	return (mixedNumber);
    }
    
    public static String simplify(int[] fraction) {
    	int whole = fraction[0];
    	int numerator = fraction[1];
    	int denominator = fraction[2];
    	if(fraction.length == 1 || numerator == 0){
    		return (Integer.toString(whole));
    	}
    	if(numerator < 0 && whole != 0){ // if numerator is negative and whole number exists
    		numerator = numerator * -1;
    	}
    	if(denominator < 0 && whole != 0){ // if denominator is negative and whole number exists
    		denominator = denominator * -1;
    	}
    	if(numerator > 0 && denominator < 0) { // if the numerator is positive and denominator is negative
    		numerator = numerator * -1; // makes the numerator negative
    		denominator = denominator * -1; // makes the denominator positive
    	}
    	int gcf = gcf(numerator, denominator); // call gcf
    	for(int i = gcf + 1; i < denominator; i++){
    		if(numerator % i == 0 && denominator % i == 0){
    			gcf = i;
    		}
    	}
    	int newNumerator = numerator / gcf; // simplifying using gcf
    	int newDenominator = denominator / gcf;
    	if(whole == 0){ // if there's no whole number
    		return(newNumerator + "/" + newDenominator);
    	}else{ // if there's whole number
    		return (whole + "_" + newNumerator + "/" + newDenominator);
    	}
    }
    
    public static int gcf(int a, int b){//determines greatest common factor
    	while(a!=0 && b!=0) {
    	int c = b;
    	b = a%b;
    	a = c;
    	}
    	return a+b;
    }
}
