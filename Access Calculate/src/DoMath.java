
public class DoMath {
	public static void main(String[] args) {
		System.out.println(Calculate.square(5));
		System.out.println(Calculate.cube(3));
		System.out.println(Calculate.average(2,2));
		System.out.println(Calculate.average(5,10,5));
		System.out.println(Calculate.toDegrees(180/3.14159));
		System.out.println(Calculate.toRadians(3.14159/180));
		System.out.println(Calculate.discriminant(2,3,4));
		System.out.println(Calculate.toImproperFrac(3,1,2));
		System.out.println(Calculate.toMixedNum(7,2));
		System.out.println(Calculate.foil(2, 3, 6, 7, "n"));
		System.out.println(Calculate.isDivisibleBy(4,2));
		System.out.println(Calculate.absValue(2));
		System.out.println(Calculate.max(4,5));
		System.out.println(Calculate.min(4,5));
		System.out.println(Calculate.round2(5));
		System.out.println(Calculate.exponent(2,4));
		System.out.println(Calculate.factorial(3));
		System.out.println(Calculate.isPrime(3));
		System.out.println(Calculate.gcf(6, 12));
	}
}