
public class Calculate {
	public static int square (int num) {
		int x=num*num;
		return x;
	}
	
	public static int cube (int number) {
		int answer;
		answer = number*number*number;
		return (answer);
	}
	
	public static double average (double number, double num) {
		return number+num/2;
	}
	
	public static double average (double number, double num, double n) {
		return number+num+n/3;
	}
	
	public static double toDegrees (double radians) {
		double answer;
		answer = 180/3.14159;
		return (answer);			
	}
	
	public static double toRadians (double degrees) {
		double answer;
		answer = 3.14159/180;
		return (answer);
	}
	
	public static double discriminant (double a, double b, double c) {
		double answer;
		answer = b*b - 4*a*c;
		return answer;
	}
	
	public static String toImproperFrac (int a, int b, int c) {
		return((a*c)+b + "/" + c);
	}
	
	public static String toMixedNum (int a, int b) {
		return (a/b + "_" + a%b + "/" + b);
	}
	
	public static String foil (int a, int b, int c, int d, String e) {
		int y = b*d;
		b = a*d + c*b;
		a = a*c;
		return(a + e + "^2 + " + b + e + " -" + y);
	}
	
	public static boolean isDivisibleBy (int a, int b) {
		if (a % b == 0 || b % a == 0) {
			return (true); 
		} else {
			return(false); }
	}
	
	public static double absValue (double a) {
		if (a > 0){
			return a;
		}else if (a < 0) {
			return a*-1;
		}else{
			return 0;
		}
	}
		
	public static int max (int a, int b) {
		if (a > b){
			return a;
		}else if (b > a) {
			return b;
		}
		return 0;
	}
	
	public static double max (double a, double b, double c) {
		if (a > b && a > c){
			return a;
		}else if (b > a && b > c) {
			return b;
		}else if (c > a && c > b) {
			return c;
		}
		return 0;
	}
	
	public static int min (int a, int b) {
		if (a < b){
			return a;
		}else if (b < a) {
			return b;
			}
		return 0;
	}
	
	public static double round2 (double a) {
		double answer;
		double intnumber = (int)(a*100);
		answer = intnumber/100;
		return answer;
		}
	
	public static double exponent (double a, int b) {
		double answer = 1;
		for (int i = 1; i<= b; i++){
		answer *= a;
		}
	return answer;
	}
	
	public static int factorial (int a) {
		int answer = 1;
		for (int i = 1; i <= a; i++){
			answer *= a;
		}
		return answer; 
		}
	
	public static boolean isPrime (int a) {
		for (int i=2; i <= a; i++) {
			if (a%i == 0)
			return (true);
		}
			return (false);
		}
	}

