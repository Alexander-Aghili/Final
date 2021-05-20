
public class Complex implements Comparable<Complex>{

	private double a;
	private double b;
	
	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public Complex(double a) {
		this.a = a;
		b = 0;
	}
	
	public Complex() {
		a = 0;
		b = 0;
	}
	
	public Complex add(Complex otherNumber) {
		double newA = this.a + otherNumber.getRealPart();
		double newB = this.b + otherNumber.getImaginaryPart();
		return new Complex(newA, newB);
	}
	
	public Complex subtract(Complex otherNumber) {
		double newA = this.a - otherNumber.getRealPart();
		double newB = this.b - otherNumber.getImaginaryPart();
		return new Complex(newA, newB);
	}
	
	public Complex multiply(Complex otherNumber) {
		return multiplyComplex(this, otherNumber);
	}
	
	//This prolly doesn't either and arthemitic exception
	public Complex divide(Complex otherNumber) {
		try {
			double denom = Math.pow(otherNumber.getRealPart(), 2) + Math.pow(otherNumber.getImaginaryPart(),2);
			System.out.println(((this.getImaginaryPart() * otherNumber.getRealPart()) + (this.getRealPart() * otherNumber.getImaginaryPart())));
			double real = ((this.getRealPart() * otherNumber.getRealPart()) + (this.getImaginaryPart() * otherNumber.getImaginaryPart())) / denom;
			double imaginary = ((this.getImaginaryPart() * otherNumber.getRealPart()) - (this.getRealPart() * otherNumber.getImaginaryPart())) / denom;
			
			return new Complex(real, imaginary);	
		} catch (Exception e) {
			return new Complex(0,0);
		}
	}
	
	private Complex multiplyComplex(Complex first, Complex second) {
		double realA = first.getRealPart() * second.getRealPart();
		double realB = (first.getImaginaryPart() * second.getImaginaryPart()) * -1;
		double imaginaryA = (first.getRealPart() * second.getImaginaryPart());
		double imaginaryB = (first.getImaginaryPart() * second.getRealPart());
		
		
		
		double realComponent = realA+realB;
		double imaginaryComponent = imaginaryA+imaginaryB;
		
		return new Complex(realComponent, imaginaryComponent);
	}
	
	public double abs() {
		return getAbsoluteValue(this.a, this.b);
	}

	public double getRealPart() {
		return a;
	}

	public double getImaginaryPart() {
		return b;
	}


	@Override
	public String toString() {
		return "(" + a + " + " + b + "i)";
	}

	@Override
	public int compareTo(Complex o) {
		
		double difference = getDifferenceInAbsoluteValue(this.a, this.b, o);
		if (difference == 0)
			return 0;
		else if (difference < 0) {
			return -1;
		} else {
			return 1;
		}
	
	}
	
	private double getDifferenceInAbsoluteValue(double a, double b, Complex o) {
		double thisValue = getAbsoluteValue(a, b);
		double otherValue = getAbsoluteValue(o.a, o.b);
		return thisValue - otherValue;
	}
	
	public double getAbsoluteValue(double a, double b) {
		double firstSquare = Math.pow(a, 2);
		double secondSquare = Math.pow(b, 2);
		double addedSquares = firstSquare + secondSquare;
		return Math.sqrt(addedSquares);
	}
	
}
