/*
 * The LinearEquationHonors class stores integers a, b, and c as the coefficient of x, the
 * coefficient of y, and the constant, respectively, from the standard form of an equation
 * for each LinearEquationHonors object
 * A LinearEquationHonors object can be constructed either by entering the slope and y-intercept
 * as Fractions, by entering four coordinates from two sets of coordinate pairs as integers, or by
 * entering the integers a, b, and c described above
 * The toString method returns a String representation of each LinearEquationHonors
 * object in slope-intercept form
 * This class contains methods to: find a y-value from a LinearEquationHonors object given an x-value;
 * find an x-value from a LinearEquationHonors object given a y-value; find the inverse of a LinearEquationHonors
 * object; compose two LinearEquationHonors objects; and find the slope and y-intercept of a LinearEquationHonors object
 */
public class LinearEquationHonors {
	// instance data
	private int a;
	private int b;
	private int c;
	
	/*
	 * Constructs a LinearEquationHonors object given a slope as a Fraction and a y-intercept as a Fraction
	 */
	public LinearEquationHonors (Fraction slope, Fraction yInt) {
		if(slope.getNumerator() > 0) {
			a = slope.getNumerator() * yInt.getDenominator();
			b = -1 * slope.getDenominator() * yInt.getDenominator();
			c = -1 * yInt.getNumerator() * slope.getDenominator();
		}
		else if (slope.getNumerator() < 0) {
			a = -1 * slope.getNumerator() * yInt.getDenominator();
			b = slope.getDenominator() * yInt.getDenominator();
			c = yInt.getNumerator() * slope.getDenominator();
		}
		else {
			b = yInt.getDenominator();
			c = yInt.getNumerator();
		}
	}
	
	/*
	 * Constructs a LinearEquationHonors object given two sets of coordinate pairs
	 * Each coordinate (x1, y1, x2, y2) is given as an integer
	 */
	public LinearEquationHonors (int x1, int y1, int x2, int y2) {
		int slopeNumer = y2 - y1;
		int slopeDenom = x2 - x1;
		int yIntNumer = (y1 - (y2 - y1)) * x1;
		int yIntDenom = x2 - x1;
		
		
		if(slopeDenom == 0) {
			a = 1;
			b = 0;
			c = yIntNumer;
		}
		else if (slopeNumer == 0) {
			a = 0;
			b = yIntDenom;
			c = yIntNumer;
		}
		else if (slopeNumer > 0) {
			a = slopeNumer * yIntDenom;
			b = -1 * slopeDenom * yIntDenom;
			c = -1 * yIntNumer * slopeDenom;
		}
		else {
			a = -1 * slopeNumer * yIntDenom;
			b = slopeDenom * yIntDenom;
			c = yIntNumer * slopeDenom;
		}
	}
	
	/*
	 * Constructs a LinearEquationHonors object given three integers a, b, and c, which are the coefficients and constants
	 * in the standard form of an equation, ax + by = c
	 */
	public LinearEquationHonors (int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public static final Fraction ZERO = new Fraction(0);
	public static final Fraction ONE = new Fraction(1);
	public static final Fraction NEG_ONE = new Fraction(-1);
	
	/*
	 * Returns a String representation of this LinearEquationHonors object
	 */
	public String toString() {
		if(b == 0) {
			return "x = " + new Fraction(c, a);
		}
		
		Fraction slope = this.getSlope();
		Fraction yInt = this.getYInt();
		
		if(a == 0) {
			return ("y = " + yInt);
		}
		else if (slope == ONE) {
			if(yInt == ZERO) {
				return ("y = x");
			}
			else if (yInt.getNumerator() < 0) {
				return ("y = x - " + new Fraction(Math.abs(yInt.getNumerator()), yInt.getDenominator()));
			}
			else {
				return ("y = x + " + yInt);
			}
		}
		else if (slope == NEG_ONE) {
			if(yInt == ZERO) {
				return ("y = -x");
			}
			else if (yInt.getNumerator() < 0) {
				return ("y = -x - " + new Fraction(Math.abs(yInt.getNumerator()), yInt.getDenominator()));
			}
			else {
				return ("y = -x + " + yInt);
			}
		}
		else {
			if(yInt == ZERO) {
				return ("y = " + slope + "x");
			}
			else if (yInt.getNumerator() < 0) {
				return ("y = " + slope + "x - " + new Fraction(Math.abs(yInt.getNumerator()), yInt.getDenominator()));
			}
			else {
				return ("y = " + slope + "x + " + yInt);
			}
		}
	}
	
	/*
	 * Given an integer x-value, returns the corresponding y-value from this LinearEquationHonors object
	 * as a Fraction
	 */
	public Fraction yGivenX(int x) {
		if(b == 0) {
			return null;
		}
		return new Fraction((-1 * a * x + c), b);
	}
	
	/*
	 * Given an integer y-value, returns the corresponding x-value from this LinearEquationHonors object
	 * as a Fraction
	 */
	public Fraction xGivenY(int y) {
		if(a == 0) {
			return null;
		}
		return new Fraction((-1 * b * y + c), a);
	}
	
	
	/*
	 * Given an x-value as a double, returns the corresponding y-value from this LinearEquationHonors object
	 * as a double
	 */
	public double yGivenX(double x) {
		if(b == 0) {
 			if(a == x) {
 				return Double.POSITIVE_INFINITY;
 			}
			return Double.NaN;
		}
		return ((-1 * a * x + c) / b);
	}
	
	/*
	 * Given a y-value as a double, returns the corresponding x-value from this LinearEquationHonors object
	 * as a double
	 */
	public double xGivenY(double y) {
		if(a == 0) {
			if(b == y) {
				return Double.POSITIVE_INFINITY;
			}
			return Double.NaN;
		}
		return ((-1 * b * y + c) / a);
	}
	
	/*
	 * Given an x-value as a Fraction, returns the corresponding y-value from this LinearEquationHonors object
	 * as a Fraction
	 */
	public Fraction yGivenX(Fraction x) {
		if(b == 0) {
			return null;
		}
		return new Fraction((x.getNumerator() * -1 * a), b).add(new Fraction(c, b));
	}
	
	/*
	 * Given a y-value as a Fraction, returns the corresponding x-value from this LinearEquationHonors object
	 * as a Fraction
	 */
	public Fraction xGivenY(Fraction y) {
		if(a == 0) {
			return null;
		}
		return new Fraction((y.getNumerator() * -1 * b), a).add(new Fraction(c, a));
	}
	
	/*
	 * Returns the inverse of this LinearEquationHonors object as a new LinearEquationHonors object
	 * The inverse of a vertical line is given as a horizontal line and the inverse of a horizontal line
	 * is given as a vertical line
	 */
	public LinearEquationHonors inverse() {
		if(this.getB() == 0) {
			return new LinearEquationHonors(0, this.getA(), this.getC());
		}
		else if(this.getA() == 0){
			return new LinearEquationHonors(this.getB(), 0, this.getC());
		}
		
		Fraction newSlope = new Fraction(1).divide(this.getSlope());
		Fraction newYInt = (new Fraction(-1).multiply(this.getYInt()).divide(this.getSlope()));
		return new LinearEquationHonors(newSlope, newYInt);
	}
	
	/*
	 * Given a LinearEquationHonors object eq, returns the composition of this LinearEquationHonors object and eq
	 * as a new LinearEquationHonors object
	 */
	public LinearEquationHonors composition(LinearEquationHonors eq) {
		return new LinearEquationHonors(this.getSlope().multiply(eq.getSlope()), this.getSlope().multiply(eq.getYInt()).add(this.getYInt()));
	}

	/*
	 * Returns the value of the coefficient of x, a, from the standard form of this LinearEquationHonors object
	 * as an integer (getter)
	 */
	public int getA() {
		return a;
	}

	/*
	 * Changes the value of the coefficient of x, a, from the standard form of this LinearEquationHonors object
	 * to the given integer parameter value, a (setter)
	 */
	public void setA(int a) {
		this.a = a;
	}

	/*
	 * Returns the value of the coefficient of y, b, from the standard form of this LinearEquationHonors object
	 * as an integer (getter)
	 */
	public int getB() {
		return b;
	}

	/*
	 * Changes the value of the coefficient of y, b, from the standard form of this LinearEquationHonors object
	 * to the given integer parameter value, b (setter)
	 */
	public void setB(int b) {
		this.b = b;
	}

	/*
	 * Returns the value of the constant, c, from the standard form of this LinearEquationHonors object
	 * as an integer (getter)
	 */
	public int getC() {
		return c;
	}

	/*
	 * Changes the value of the constant, c, from the standard form of this LinearEquationHonors object
	 * to the given integer parameter value, c (setter)
	 */
	public void setC(int c) {
		this.c = c;
	}
	
	/*
	 * Returns the value of the slope of this LinearEquationHonors object as a Fraction
	 */
	public Fraction getSlope() {
		if(this.getB() == 0) {
			return new Fraction(0);
		}
		
		return new Fraction((-1 * this.getA()), this.getB());
	}
	
	/*
	 * Returns the value of the y-intercept of this LinearEquationHonors object as a Fraction
	 */
	public Fraction getYInt() {
		if(this.getB() == 0) {
			return new Fraction(this.getB());
		}
		
		return new Fraction(this.getC(), this.getB());
	}
}