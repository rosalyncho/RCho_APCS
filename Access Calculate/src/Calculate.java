// Rosalyn Cho
// Calculate Library
// 10/29/2016

public class Calculate {
	
// Part 1: Methods, Headers, and Basic Math	
	public static int square (int a) { // accepts and returns an integer
		return a*a; // returns the square of the value passed
	}
	
	public static int cube (int a) { // accepts and returns an integer
		return a*a*a; // returns the cube of the value passed
	}
	
	public static double average (double num1, double num2) { // accepts two doubles and returns a double
		return (num1 + num2)/2; // returns the average of the values passed
	}
	
	public static double average (double num1, double num2, double num3) { // accepts three doubles and returns a double
		return (num1 + num2 + num3)/3; // returns the average of the values passed
	}
	
	public static double toDegrees (double radians) { // accepts a double and returns a double
		return (180/3.14159)*(radians); // converts an angle measure given in radians into degrees
	}
	
	public static double toRadians (double degrees) { // accepts a double and returns a double
		return (3.14159/180)*(degrees); // converts an angle measure given in degrees into radians
	}
	
	public static double discriminant (double a, double b, double c) { // accepts three doubles and returns a double
		return b*b - 4*a*c; // returns the value of the discriminant
	}
	
	public static String toImproperFrac (int wholenumber, int numerator, int denominator) { // accepts three integers and returns a String
		return ((wholenumber*denominator)+numerator + "/" + denominator); // converts mixed number into an improper fraction
	}
	
	public static String toMixedNum (int numerator, int denominator) { // accepts two integers and returns a String
		// converts an improper fraction into a mixed number
	    boolean check = Calculate.isDivisibleBy(numerator, denominator);
	    if (check == true) {
		return numerator/denominator + "";
	    } else {
		return numerator/denominator + "_" + numerator % denominator + "/" + denominator;
		}
	}
	
	public static String foil (int a, int b, int c, int d, String e) { // accepts four integers and a String and returns a String
		// converts a binomial multiplication of the form (ax + b)(cx + d)
		int last = b*d;
		int middle = a*d + c*b;
		int first = a*c;
		double check = (int) Calculate.absValue(last);
		if (last > 0) {
		return (first + e + "^2 + " + middle + e + " + " + check);
		} else {
		return (first + e + "^2 + " + middle + e + " – " + (int) check);
		}
	}

// Part 2: Methods with Conditionals
	public static boolean isDivisibleBy (int num1, int num2) { // accepts two integers and returns a boolean
		// determines whether or not one integer is evenly divisible by another
		if (num2 == 0 || num1 == 0) {
			throw new IllegalArgumentException("divisor : 0");
		}
		if (num1 % num2 == 0 || num2 % num1 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static double absValue (double a) { // accepts a double and returns a double
		// returns the absolute value of the number passed
		if (a > 0) {
			return a;
		} else {
			return a*-1;
		}
	}
	
	public static int max (int num1, int num2) { // accepts two integers and returns a boolean
		// returns the larger of the values passed
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	public static double max (double number1, double number2, double number3) { // accepts three doubles and returns a double
		// returns the largest of the values passed
		if (number1 > number2 && number1 > number3) {
			return number1;
		} else if (number2 > number1 && number2 > number3) {
			return number2;
		} else {
			return number3;
		}
	}
	
	public static int min (int number1, int number2) { // accepts two integers and returns an integer
		// returns the smaller of the values passed
		if (number1 < number2) {
			return number1;
		} else {
			return number2;
		}
	}
	
	public static double round2 (double a) { // accepts and returns a double 
		// rounds a double correctly to 2 decimal places
		double intnumber = (int)(a*100);
		double answer;
		if ((100*a) - intnumber >= .5) {
			answer = (int) (100*a+1);
			answer /= 100;
			return answer;
		} else {
			answer = (int) (100*a);
			answer /= 100;
			return answer;
		}
	}
	
// Part 3: Methods that use Loops and Calls to Other Methods
	public static double exponent (double base, int power) { // accepts a double and an integer and returns a double
		// raises a value to a positive integer power
		if (power < 0) {
			throw new IllegalArgumentException("negative exponent: " + power);
		}
		double answer = 1;
		for (int i = 1; i <= power; i++) {
			answer *= base;
		}
		return answer;
	}
	
	public static int factorial (int a) { // accepts an integer and returns an integer
		// returns the factorial of the value passed
		if (a < 0) {
			throw new IllegalArgumentException("negative a: " + a);
		}
		int answer = 1;
	    for ( int i = 2; i <= a; i++ ) {  
	        answer *= i;
	    }  
	    return answer;
	}  
	
	public static boolean isPrime (int a) { // accepts an integer and returns a boolean
		// determines whether or not an integer is prime
	    boolean check;
	    if (a > 1) {
	    	for (int i = a - 1; i > 1; i--) {
	    		check = Calculate.isDivisibleBy(a, i);
	    		if (check == true) {
	    			return false;
	    		}
	    	}
	    } else {
	    	return false;
	    }
	    return true;
		}

	public static int gcf (int num1, int num2) { // accepts two positive integers and returns an integer
		// finds the greatest common factor of two integers
		 int answer = 1;
		 int check = Calculate.max(num1, num2);
		 if (check == num1) {
		        for(int i = num1; i >= 1; i--){
		            if(num1 % i == 0 && num2 % i == 0){
		                return i;
		            }
		        }
		    } else {
		        for (int j = num1; j >= 1; j--){
		            if (num1 % j == 0 && num2 % j == 0){
		                return j;
		            }
		        }
		    }   
		    return answer;
	}

	public static double sqrt (double a) { // accepts and returns a double
		// returns an approximation of the square root of the value passed, accurate to two decimal places
//		if (a < 0) {
//			throw new IllegalArgumentException ("negative a:" + a);
//		}
		return Math.sqrt(a);
	}
	
// Part 4: Throwing Exceptions
	// 1. See factorial, exponent, isDivisibleBy, and sqrt
	// 2.
	public static String quadForm (int a, int b, int c) { // accepts three integers and returns a String
		// uses the coefficients of a quadratic equation in standard form and uses the quadratic formula to approximate the real roots
		double answer = (double) Calculate.discriminant(a, b, c);
		double discriminantRoot = Calculate.sqrt(answer);
	    double root1 = (-b + discriminantRoot) / (2 * a);
	    double root2 = (-b - discriminantRoot) / (2 * a);
	    if (answer < 0) {
	        return ("no real roots");
	    } else if (answer > 0) {
	        return (root2 + "0 and " + root1 + "0");
	    } else if (answer == 0) {
	    	return (root1 + "0");
	    }
		return 0 + "";
	}
}