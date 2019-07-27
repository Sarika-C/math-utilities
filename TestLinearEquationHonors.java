/*
 * Tests methods from the LinearEquationHonors class
 */
public class TestLinearEquationHonors {

	public static void main(String[] args) {	
			int[][] nums = {{2, -1, -3},
							{4, 1, -5},
							{2, -1, 3},
							{4, 1, 5},
							{2, -3, -9},
							{0, 3, 5},
							{4, 0, 5},
							{2, 3, 4, 5},
							{-4, -7, 8, -7},
							{0, 3, 0, 56},
							{2, 0, -9, 54},
							{0, 5, 0, 10}};
			
			Fraction[][] fracs = {{new Fraction(2), new Fraction(3)},
									{new Fraction(-4), new Fraction(-7)},
									{new Fraction(0), new Fraction(0)},
									{new Fraction(0), new Fraction(3)},
									{new Fraction(2), new Fraction(0)},
									{new Fraction(5), new Fraction(-1)},
									{new Fraction(-3), new Fraction(2)}};
			
			LinearEquationHonors[] tests = new LinearEquationHonors [nums.length + fracs.length];
			
			int j = 0;
			for(int i = 0; i < nums.length; i++) {
				if(nums[i].length == 3 ) {
					tests[j] = new LinearEquationHonors(nums[i][0], nums[i][1], nums[i][2]);
					System.out.println("A line with a = " + nums[i][0] + ", b = " + 
							nums[i][1] + ", and c = " + nums[i][2] + " is " + tests[j]);	
				}
				else {
					tests[j] = new LinearEquationHonors(nums[i][0], nums[i][1], nums[i][2], nums[i][3]);
					System.out.println("A line containing the points (" + nums[i][0] + ", " + nums[i][1] + 
										") and (" + nums[i][2] + ", " + nums[i][3] + ") is " + tests[j]);
				}
				
				j++;
			}
			
			int k = j;
			for(int i = 0; i < fracs.length; i++) {
				tests[k] = new LinearEquationHonors(fracs[i][0], fracs[i][1]);
				
				System.out.println("A line with slope " + tests[k].getSlope() + " and y-intercept " + 
									tests[k].getYInt() + " is " + tests[k]);
				
				k++;
			}
			
			LinearEquationHonors f = new LinearEquationHonors(new Fraction(2), new Fraction(3));
			
			for(LinearEquationHonors eq: tests) {
				System.out.println("Equation: " + eq);
				System.out.println("Given x = " + 2 + ", y = " + eq.yGivenX(2));
				System.out.println("Given y = " + 3 + ", x = " + eq.xGivenY(3));
				System.out.println("Inverse: " + eq.inverse());
				System.out.println("The composition of " + eq + " and " + f + " is " + eq.composition(f));
				System.out.println("The composition of " + f + " and " + eq + " is " + f.composition(eq));
			}

	}

}
