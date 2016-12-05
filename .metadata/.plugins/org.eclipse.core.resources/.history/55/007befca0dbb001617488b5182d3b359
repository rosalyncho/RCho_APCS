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
    	
    	String [] operator=parseInput(input);
		int [] firstOperand=parseFractions(operator[0]);
		int [] secondOperand=parseFractions(operator[2]);
		int[] answer = new int [2];
        if (operator[1].equals("+")){
        	answer = addFrac(firstOperand,secondOperand);
        }else if(operator[1].equals("-")){
        	answer = subtractFrac(firstOperand,secondOperand);
        }else if(operator[1].equals("*")){
        	answer = multiplyFrac(firstOperand,secondOperand);
        }else if(operator[1].equals("/")){
        	answer = divideFrac(firstOperand,secondOperand);
        }
        return(toMixedNum(answer));
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
    //		toImproperFrac(wholeNumber,numerator,denominator);
    	}
    	int[] improperFrac = toImproperFrac(answer[0], answer[1], answer[2]);
    	return improperFrac;
    	
    }
    
 // converts mixed number into an improper fraction
    public static int[] toImproperFrac (int wholeNumber, int numerator, int denominator) {
    	int[] toImproperFrac = new int[2];
		toImproperFrac[0] = wholeNumber * denominator + numerator;
		toImproperFrac[1] = denominator;
		return toImproperFrac;
	}
    
    public static int[] addFrac(int[] firstOperand, int[] secondOperand)
    {
    	int[] answer = new int[2];
    	if(firstOperand[1] == secondOperand[1]){
    		answer[0] = firstOperand[0] + secondOperand[0];
    		answer[1] = firstOperand[1];
    	}else{
    		firstOperand[0] = firstOperand[0] * secondOperand[1];
    		secondOperand[0] = secondOperand[0] * firstOperand[1];
    		answer[0] = firstOperand[0] + secondOperand[0];
    		answer[1] = firstOperand[1] * secondOperand[1];
    	}
		return answer;
    }
    
    public static int[] subtractFrac(int[] firstOperand, int[] secondOperand)
    {
    	secondOperand[0]=secondOperand[0]*-1;
		return addFrac(firstOperand, secondOperand);
    }
    
    public static int[] multiplyFrac(int[] firstOperand, int[] secondOperand)
    {
    	int[] answer = new int[2];
		answer[0]= firstOperand[0]*secondOperand[0];
		answer[1] = firstOperand[1]*secondOperand[1];
		return answer;
    }
    
    public static int[] divideFrac(int[] firstOperand, int[] secondOperand)
    {
    	int[] answer = new int[2];
		answer[0]=secondOperand[1];
		answer[1]=secondOperand[0];
		return multiplyFrac(firstOperand, answer);
    }
    
    public static String toMixedNum(int[] frac){
    	int wholeNumber = frac[0] / frac[1];
    	int numerator = frac[0] % frac[1];
    	int denominator = frac[1];
    	if(numerator < 0){
    		numerator *= -1;
    	}
    	if(denominator < 0){
    		denominator *= -1;
    	}
    	return (wholeNumber + "_" + numerator + "/" + denominator);
    }

}
