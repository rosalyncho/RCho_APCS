// Programmer 1: Rosalyn Cho
// Programmer 2: Max Russell
// Collaborative Programming Exercise
// 10/2/2016
// Period 2

import java.util.*;
public class ProcessingNumbers {
	public static void main (String[] args) {
		Scanner userInput = new Scanner (System.in);
		System.out.print("How many numbers are you entering? ");
		int inputNumber = userInput.nextInt();
		System.out.print("Enter your numbers.");
		int max = userInput.nextInt();
		int min = max;
		int totalEven = 0;
		int largestEven = 0;
		if (max % 2 == 0) {
			totalEven = max;
			largestEven = max;
		} 
		for (int i = 2; i <= inputNumber; i++) {
			int next = userInput.nextInt();
			if (next > max) {
				max = next;
			} if (next < min) {
				min = next;
			} if (next % 2 == 0) {
				totalEven += next;
				largestEven = next;
				} 
			}   
			System.out.println("This is the largest even number: " + largestEven);
			System.out.println("This is the smallest number: " + min);
			System.out.println("This is the largest number: " + max);
			System.out.println("This is the sum of all the even numbers: " + totalEven);
	}
}