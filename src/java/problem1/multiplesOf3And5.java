import java.util.*; // for ArrayList

/**
* @author Claire Jaja
* @version 11/24/13
*
* Project Euler Problem 1
* Multiples of 3 and 5
* If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
* The sum of these multiples is 23.
* Find the sum of all the multiples of 3 or 5 below 1000.
*/

public class MultiplesOf3And5
{
	// a global variable for the integer to calculate multiples to
	private static int num = 1000;

	public static void main(String[] args) {
		ArrayList<Integer> multiples = new ArrayList<Integer>();
		// go through all numbers up to num
		for (int i = 3; i < num; i++) {
			// any that are multiple of 3 or 5 get added to array
			if (i % 3 == 0 || i % 5 == 0) {
				multiples.add(i);
			}
		}

		// sum all the numbers in the array
		int sum = 0;
		for (int i = 0; i < multiples.size(); i++) {
			sum += multiples.get(i);
		}

	System.out.println(sum);
	}
}
