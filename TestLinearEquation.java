/*
 * Tests methods from the LinearEquation class
 */
public class TestLinearEquation {

	public static void main(String[] args) {	
		double[][] nums = {{2, 3},
							{-4, -7},
							{0, 1},
							{0, -1},
							{0, 0},
							{2, 0},
							{1, 0},
							{1, -1},
							{-1, 3},
							{-1, -5},
							{5.7, 100.9},
							{2, 3, 4, 5},
							{-4, -7, 8, -7},
							{0, 0, 0, 0},
							{0, 3, 0, 56},
							{2, 0, -9, 54},
							{5.7, 100.9, -9, -12}};
		
		LinearEquation[] tests = new LinearEquation [nums.length];
		
		int j = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i].length == 2 ) {
				tests[j] = new LinearEquation(nums[i][0], nums[i][1]);
				System.out.println("A line with slope " + tests[j].getSlope() + " and y-intercept " + 
									tests[j].getYInt() + " is " + tests[j]);
				
			}
			else {
				tests[j] = new LinearEquation(nums[i][0], nums[i][1], nums[i][2], nums[i][3]);
				System.out.println("A line containing the points (" + nums[i][0] + ", " + nums[i][1] + 
									") and (" + nums[i][2] + ", " + nums[i][3] + ") is " + tests[j]);
			}
			
			j++;
		}
		
		LinearEquation f = new LinearEquation(2, 3);
		
		for(LinearEquation eq: tests) {
			System.out.println("Equation: " + eq);
			System.out.println("Given x = " + 2 + ", y = " + eq.yGivenX(2));
			System.out.println("Given y = " + 3 + ", x = " + eq.xGivenY(3));
			System.out.println("Inverse: " + eq.inverse());
			System.out.println("The composition of " + eq + " and " + f + " is " + eq.composition(f));
			System.out.println("The composition of " + f + " and " + eq + " is " + f.composition(eq));
		}

	}

}
