/*
 * The LinearEquation class stores doubles m and b as the slope and y-intercept, respectively,
 * from the slope-intercept form of an equation for each LinearEquation object
 * A LinearEquation object can be constructed either by entering the slope and y-intercept
 * as doubles or by entering four coordinates from two sets of coordinate pairs as doubles
 * The toString method returns a String representation of each LinearEquation object in
 * slope-intercept form
 * This class contains methods to: find a y-value from a LinearEquation given an x-value;
 * find an x-value from a LinearEquation given a y-value; find the inverse of a LinearEquation;
 * and compose two LinearEquations
 * This class cannot handle vertical lines, which have undefined slopes
 */
public class LinearEquation {
	// instance data
	private double m;
	private double b;
	
	/*
	 * Constructs a LinearEquation object given a slope as a double and a y-intercept as a double
	 */
	public LinearEquation(double slope, double yInt) {
		m = slope;
		b = yInt;
	}
	
	/*
	 * Constructs a LinearEquation object given two sets of coordinate pairs
	 * Each coordinate (x1, y1, x2, y2) is given as a double
	 */
	public LinearEquation(double x1, double y1, double x2, double y2) {
		m = (y2 - y1) / (x2 - x1);
		b = y1 - (m * x1);
	}
	
	/*
	 * Returns a String representation of this LinearEquation object
	 */
	public String toString() {
		if(m == 0) {
			return ("y = " + b);
		}
		else if (m == 1) {
			if(b == 0) {
				return ("y = x");
			}
			else if (b < 0) {
				return ("y = x - " + Math.abs(b));
			}
			else {
				return ("y = x + " + b);
			}
		}
		else if (m == -1) {
			if(b == 0) {
				return ("y = -x");
			}
			else if (b < 0) {
				return ("y = -x - " + Math.abs(b));
			}
			else {
				return ("y = -x + " + b);
			}
		}
		else {
			if(b == 0) {
				return ("y = " + m + "x");
			}
			else if (b < 0) {
				return ("y = " + m + "x - " + Math.abs(b));
			}
			else {
				return ("y = " + m + "x + " + b);
			}
		}
	}
	
	/*
	 * Given an x-value as a double, returns the corresponding y-value from this LinearEquation as a double
	 */
	public double yGivenX(double x) {
		return (m * x + b);
	}
	
	/*
	 * Given a y-value as a double, returns the corresponding x-value from this LinearEquation as a double
	 */
	public double xGivenY(double y) {
		if(m == 0) {
			return Double.POSITIVE_INFINITY;
		}
		return ((y - b) / m);
	}
	
	/*
	 * Returns the inverse of this LinearEquation as a new LinearEquation
	 */
	public LinearEquation inverse() {
		double newSlope = 1 / this.getSlope();
		double newYInt = (-1 * this.getYInt()) / (this.getSlope());
		return new LinearEquation(newSlope, newYInt);
	}
	
	/*
	 * Given a LinearEquation eq, returns the composition of this LinearEquation and eq as a new LinearEquation
	 */
	public LinearEquation composition(LinearEquation eq) {
		return new LinearEquation(this.getSlope() * eq.getSlope(), this.getSlope() * eq.getYInt() + this.getYInt());
	}

	/*
	 * Returns the value of the slope of this LinearEquation as a double (getter)
	 */
	public double getSlope() {
		return m;
	}

	/*
	 * Changes the value of the slope of this LinearEquation to the given double parameter value, m (setter)
	 */
	public void setSlope(double m) {
		this.m = m;
	}

	/*
	 * Returns the value of the y-intercept of this LinearEquation as a double (getter)
	 */
	public double getYInt() {
		return b;
	}

	/*
	 *  Changes the value of the y-intercept of this LinearEquation to the given double parameter value, b (setter)
	 */
	public void setYInt(double b) {
		this.b = b;
	}
	
}
