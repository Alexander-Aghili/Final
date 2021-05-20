import java.util.Scanner;

public class ComplexDriver {

	public static void main(String[] args) {
		Complex firstComplex = getComplexNumberFromUser("first");
		Complex secondComplex = getComplexNumberFromUser("second");
		
		Complex addedComplex = firstComplex.add(secondComplex);;
		Complex subtractedComplex = firstComplex.subtract(secondComplex);;
		Complex multipliedComplex = firstComplex.multiply(secondComplex);;
		Complex dividedComplex = firstComplex.divide(secondComplex);;
		double absoluteValueFirst = firstComplex.abs();
		double absoluteValueSecond = secondComplex.abs();
		
		System.out.println(firstComplex.toString() + " + " + secondComplex.toString() + " = " + addedComplex.toString());
		System.out.println(firstComplex.toString() + " - " + secondComplex.toString() + " = " + subtractedComplex.toString());
		System.out.println(firstComplex.toString() + " * " + secondComplex.toString() + " = " + multipliedComplex.toString());
		if (dividedComplex.getRealPart() != 0 && dividedComplex.getImaginaryPart() != 0) 
			System.out.println(firstComplex.toString() + " / " + secondComplex.toString() + " = " + dividedComplex.toString());
		else 
			System.out.println("This doesn't divide");
		
		System.out.println("|" + firstComplex.toString() + "| = " + absoluteValueFirst);
		System.out.println("|" + secondComplex.toString() + "| = " + absoluteValueSecond);
		
	}
	
	private static Complex getComplexNumberFromUser(String number) {
		Scanner input = new Scanner(System.in);
		double secondNumber = 0;
		double firstNumber = 0;
		boolean validInput = false;
		
		while(!validInput) {
			System.out.print("Enter the " + number + " complex number: ");
			String userInput = input.nextLine().trim();
			
			try {
				firstNumber = checkValidNumber(userInput.substring(0, userInput.indexOf(" ")));
				secondNumber = checkValidNumber(userInput.substring(userInput.indexOf(" ") + 1));
				validInput = true;
			} catch (Exception e) {
				System.out.println("There was an error with the input. Ensure you entered it correctly. Try Again.\n");
			}
		}
		
		return new Complex(firstNumber, secondNumber);
	}
	
	private static double checkValidNumber(String possibleNumber) throws Exception{
		return Double.parseDouble(possibleNumber);
	}
	

}
