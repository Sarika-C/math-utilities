/*
 * Tests methods from the Fraction class
 */

import java.util.ArrayList;

public class TestFraction {

	public static void main(String[] args) {
		double[] numerators   = {3, -4, 0, 0, 2, 5, -3, 2, 7, 4, 5, 6};
		double[] denominators = {4, -7, 0, 3, 0, -1, 2, 3, 6, 1, 10, 1};
		Fraction[] fracs = {new Fraction(3, 4),
				new Fraction(-4, -7),
				new Fraction(0, 0),
				new Fraction(0, 3),
				new Fraction(2, 0),
				new Fraction(5, -1),
				new Fraction(-3, 2),
				new Fraction(2, 3),
				new Fraction(7, 6), 
				new Fraction(4, 1),
				new Fraction(5, 10),
				new Fraction(6)};
		
		Fraction f = new Fraction(1, 2);

		for(int i = 0; i < numerators.length; i++) {
			System.out.println("A simplified fraction with numerator " + numerators[i] + " and denominator " + 
								denominators[i] + " is " + fracs[i]);
			System.out.println(fracs[i] + " times " + f + " is " + fracs[i].multiply(f));
			System.out.println(fracs[i] + " times " + 2 + " is " + fracs[i].multiply(2));
			System.out.println(fracs[i] + " divided by " + f + " is " + fracs[i].divide(f));
			System.out.println(fracs[i] + " divided by " + 2 + " is " + fracs[i].divide(2));
			System.out.println(fracs[i] + " plus " + f + " is " + fracs[i].add(f));
			System.out.println(fracs[i] + " plus " + 2 + " is " + fracs[i].add(2));
			System.out.println(fracs[i] + " minus " + f + " is " + fracs[i].subtract(f));
			System.out.println(fracs[i] + " minus " + 2 + " is " + fracs[i].subtract(2));
			System.out.println(fracs[i] + " as a decimal is " + fracs[i].toDecimal());
			System.out.println("The reciprocal of " + fracs[i] + " is " + fracs[i].reciprocal());
			System.out.println("The opposite of " + fracs[i] + " is " + fracs[i].opposite());
		}
		
		MixedNumber m = new MixedNumber(7, -3);
		System.out.println(m);
		
		ArrayList<Fraction> tests = new ArrayList<Fraction>();
		
		tests.add(f);
		tests.add(m);
		
		System.out.println(tests);
		
		for(Fraction z: tests) {
			System.out.println(z.reciprocal());
			}
	}
}