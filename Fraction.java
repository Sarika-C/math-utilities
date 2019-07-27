/*
 * The Fraction class stores integers as the numerator and denominator of each Fraction object as the instance data
 * A Fraction object can be constructed either by entering the numerator and denominator as integers or by entering just
 * the numerator as an integer, which causes the denominator to become 1
 * This class contains methods to: add and subtract Fractions to and from each other
 * and to and from integers; multiply and divide Fractions by each other and by
 * integers; convert Fractions into decimal form; find the reciprocal of a Fraction;
 * find the opposite of a Fraction; and simplify a Fraction
 */
public class Fraction {
	
	// instance data
	protected int numerator;
	protected int denominator;
	
	/*
	 * Constructs a Fraction object given an integer numerator and an integer denominator
	 */
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		simplify();
	}
	
	/*
	 * Constructs a Fraction object given an integer n
	 */
	public Fraction(int n) {
		this(n, 1);
	}
	
	/*
	 * Returns a String representation of this Fraction object
	 */
	public String toString() {
		if(this.denominator == 1) {
			return "" + numerator;
		}
		else if (this.denominator == 0) {
			return "" + Double.NaN;
		}
		
		return this.numerator + "/" + this.denominator;
	}
	
	/*
	 * Returns the product of this Fraction with the Fraction parameter f as a new Fraction
	 */
	public Fraction multiply(Fraction f) {
		return new Fraction(this.numerator * f.getNumerator(), this.denominator * f.getDenominator());
	}
	
	/*
	 * Returns the product of this Fraction with the integer parameter n as a new Fraction
	 */
	public Fraction multiply(int n) {
		return new Fraction(this.numerator * n, this.denominator);
	}
	
	/*
	 * Returns the quotient of this Fraction divided by the Fraction parameter f as a new Fraction
	 */
	public Fraction divide(Fraction f) {
		return this.multiply(f.reciprocal());
	}
	
	/*
	 * Returns the quotient of this Fraction divided by the integer parameter n as a new Fraction
	 */
	public Fraction divide(int n) {
		return new Fraction(this.numerator, this.denominator * n);
	}
	
	/*
	 * Returns the sum of this Fraction added to the Fraction parameter f as a new Fraction
	 */
	public Fraction add(Fraction f) {
		int newNumer = this.numerator * f.getDenominator() + this.denominator * f.getNumerator();
		int newDenom = this.denominator * f.getDenominator();
		
		return new Fraction(newNumer, newDenom);
	}
	
	/*
	 * Returns the sum of this Fraction added to the integer parameter n as a new Fraction
	 */
	public Fraction add(int n) {
		Fraction f = new Fraction(n);
		int newNumer = this.numerator * f.getDenominator() + this.denominator * f.getNumerator();
		int newDenom = this.denominator * f.getDenominator();
		
		return new Fraction(newNumer, newDenom);
	}
	
	/*
	 * Returns the difference of this Fraction minus the Fraction parameter f as a new Fraction
	 */
	public Fraction subtract(Fraction f) {
		int newNumer = this.numerator * f.getDenominator() - this.denominator * f.getNumerator();
		int newDenom = this.denominator * f.getDenominator();
		
		return new Fraction(newNumer, newDenom);
	}
	
	/*
	 * Returns the difference of this Fraction minus the integer parameter n as a new Fraction
	 */
	public Fraction subtract(int n) {
		Fraction f = new Fraction(n);
		int newNumer = this.numerator * f.getDenominator() - this.denominator * f.getNumerator();
		int newDenom = this.denominator * f.getDenominator();
		
		return new Fraction(newNumer, newDenom);
	}
	
	/*
	 * Returns the decimal equivalent of this Fraction as a double
	 */
	public double toDecimal() {
		return (double) numerator / denominator;
	}
	
	/*
	 * Returns the reciprocal of this Fraction as a new Fraction
	 */
	public Fraction reciprocal() {
		return new Fraction(this.denominator, this.numerator);
	}
	
	/*
	 * Returns the opposite of this Fraction as a new Fraction
	 */
	public Fraction opposite() {
		return new Fraction(-1 * this.numerator, this.denominator);
	}
	
	/*
	 * Returns the value of the numerator of this Fraction as an integer (getter)
	 */
	public int getNumerator() {
		return this.numerator;
	}
	
	/*
	 * Changes the value of the numerator of this Fraction to the given integer parameter value, numerator (setter)
	 */
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	/*
	 *  Returns the value of the denominator of this Fraction as an integer (getter)
	 */
	public int getDenominator() {
		return denominator;
	}

	/*
	 * Changes the value of the denominator of this Fraction to the given integer parameter value, denominator (setter)
	 */
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	/*
	 * Simplifies this Fraction to a new Fraction in which the numerator and denominator have no common factor
	 * other than 1
	 */
	public void simplify() {
		if(this.denominator == 0) {
			this.numerator = 0;
		}
		else {
			int gcd = gcd(this.numerator, this.denominator);
			if(this.denominator < 0) {
				gcd = -gcd;
			}
			this.numerator /= gcd;
			this.denominator /= gcd;
		}
	}
	
	/*
	 * Given two integers a and b, returns their greatest common factor as an integer
	 */
	//private bc not associated with fractions and static bc belongs to class, not Fraction object
	private static int gcd(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		
		while(b != 0) {
			int remainder = a % b;
			a = b;
			b = remainder;
		}
		
		return a;
	}

}
