// Rosalyn Cho
// Do Math
// 10/15/2016

public class DoMath {
	public static void main(String[] args) {
		System.out.println(Calculate.square(5));
		System.out.println(Calculate.cube(3));
		System.out.println(Calculate.average(5.5,5.9));
		System.out.println(Calculate.average(5.1,5.4,5.6));
		System.out.println(Calculate.toDegrees(3.14159/6));
		System.out.println(Calculate.toRadians(180.0));
		System.out.println(Calculate.discriminant(2.0, 3.0, 4.0));
		System.out.println(Calculate.toImproperFrac(3, 1, 2));
		System.out.println(Calculate.toMixedNum(7, 2));
		System.out.println(Calculate.foil(2, 3, 4, 5, "n"));
		System.out.println(Calculate.isDivisibleBy(4, 2));
		System.out.println(Calculate.absValue(-2.2));
		System.out.println(Calculate.max(4, 5));
		System.out.println(Calculate.max(4.2, 5.5, 5.8));
		System.out.println(Calculate.min(4,5));
		System.out.println(Calculate.round2(42.36));
		System.out.println(Calculate.exponent(2.5, 3));
		System.out.println(Calculate.factorial(4));
		System.out.println(Calculate.isPrime(3));
		System.out.println(Calculate.gcf(10, 15));
		System.out.println(Calculate.sqrt(4));
		System.out.println(Calculate.quadForm(1, -6, 9));
	}
}