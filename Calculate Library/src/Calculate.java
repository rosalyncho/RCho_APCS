
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
		String answer = (a*c) + b;
		return (answer + "/" + c);
	}
	
	public static String toMixedNum (int a, int b) {
		String answer = ((a/b)/b);
		return (answer);
	}
	
	public static String foil (int a, int b, int c, int d, String e) {
		return (a*c + "x^2" + "+" + a*d + b*c+ "x" + "+" + b*d);
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
	}
	
	public static double max (double a, double b, double c) {
		if (a > b && a > c){
			return a;
		}else if (b > a && b > c) {
			return b;
		}else if (c > a && c > b) {
			return c;
		}
	}
	
	public static int min (int a, int b) {
		if (a < b){
			return a;
		}else if (b < a) {
			return b;
			}
	}
	
	public static double round2 (double a) {
		}
	}
}	
