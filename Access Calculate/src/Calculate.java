// Rosalyn Cho
// Calculate Library
// 10/15/2016

public class Calculate {
	
// Part 1: Methods, Headers, and Basic Math	
	public static int square (int a) {
		return a*a;
	}
	
	public static int cube (int num) {
		return num*num*num;
	}
	
	public static double average (double num1, double num2) {
		return (num1 + num2)/2;
	}
	
	public static double average (double num1, double num2, double num3) {
		return (num1 + num2 + num3)/3;
	}
	
	public static double toDegrees (double radians) {
		return (180/3.14159)*(radians);
	}
	
	public static double toRadians (double degrees) {
		return (3.14159/180)*(degrees);
	}
	
	public static double discriminant (double num1, double num2, double num3) {
		return num2*num2 - 4*num1*num3;
	}
	
	public static String toImproperFrac (int a, int b, int c) {
		return ((a*c)+b + "/" + c);
	}
	
	public static String toMixedNum (int a, int b) {
		return (a/b + "_" + a%b + "/" + b);
	}
	
	public static String foil (int a, int b, int c, int d, String e) {
		int y = b*d;
		b = a*d + c*b;
		a = a*c;
		return (a + e + "^2 + " + b + e + " + " + y);
	}

// Part 2: Methods with Conditionals
	public static boolean isDivisibleBy (int num1, int num2) {
		if (num2 == 0 || num1 == 0) {
			throw new IllegalArgumentException("divisor : 0");
		}
		if (num1 % num2 == 0 || num2 % num1 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static double absValue (double a) {
		if (a > 0) {
			return a;
		} else if (a < 0) {
			return a*-1;
		} else{
			return 0;
		}
	}
	
	public static int max (int a, int b) {
		if (a > b) {
			return a;
		} else if (b > a) {
			return b;
		} else {
			return 0;
		}
	}
	
	public static double max (double a, double b, double c) {
		if (a > b && a > c) {
			return a;
		} else if (b > a && b > c) {
			return b;
		} else if (c > a && c > b) {
			return c;
		} else {
			return 0;
		}
	}
	
	public static int min (int a, int b) {
		if (a < b) {
			return a;
		} else if (b < a) {
			return b;
		} else {
			return 0;
		}
	}
	
	public static double round2 (double a) {
		double answer;
		double intnumber = (int)(a*100);
		answer = intnumber/100;
		return answer;
	}
	
// Part 3: Methods that use Loops and Calls to Other Methods
	public static double exponent (double a, int b) {
		if (b < 0) {
			throw new IllegalArgumentException("negative b: " + b);
		}
		double answer = 1;
		for (int i = 1; i <= b; i++) {
			answer *= a;
		}
		return answer;
	}
	
	public static int factorial (int a) {
		if (a < 0) {
			throw new IllegalArgumentException("negative a: " + a);
		}
		int answer = 1;
	    for ( int i = 2; i <= a; i++ ) {  
	        answer *= i;
	    }  
	    return answer;
	}  
	
	public static boolean isPrime (int a) {
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

	public static int gcf (int num1, int num2) {
		while (num2 != 0) {
			int c = num1;
			num1 = num2;
			num2 = c % num2;
		}
		return (int)Calculate.absValue(num1);
	}
	
	public static double sqrt (double a) {
		if (a < 0) {
			throw new IllegalArgumentException ("negative a:" + a);
		}
		return Math.sqrt(a);
	}
	
// Part 4: Throwing Exceptions
	// 1. See factorial, exponent, isDivisibleBy, and sqrt
	// 2.
	public static String quadForm (int a, int b, int c) {
		double answer = Calculate.discriminant(a, b, c);
		double discriminantRoot = Calculate.sqrt(answer);
	    double root1 = (-b + discriminantRoot) / (2 * a);
	    double root2 = (-b - discriminantRoot) / (2 * a);
	    if (answer < 0) {
	        return ("no real roots");
	    } else if (answer > 0){
	        return (root1 + " and " + root2);
	    } else if (answer == 0) {
	    	return (root1 + "" + root2);
	    }
		return 0 + "";
	}
}