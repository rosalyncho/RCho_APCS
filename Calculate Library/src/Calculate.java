
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
		String answer;
		answer = (a*c) + b;
		return (answer + "/" c);
	}
	
	public static String toMixedNum (int a, int b) {
		int answer;
		answer = ((a/b)/b);
		return (answer);
	}
	
	public static String foil (int a, int b, int c, int d, String e) {
		int answer;
		answer = a*c;
		answer = b*c;
		return (a + "x^2" + "+" b + "x" + "+" c);
	}
	
	public static int isDivisibleBy
}	
