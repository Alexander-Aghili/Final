
public class PythagoreanTriangle {

	private static int A, B, C;
	
	public static void main(String[] args) {
		getTripletNumbers();
		int product = A*B*C;
		System.out.println("The Product is: " + product);

	}
	
	private static void getTripletNumbers() {
		int a = 0, b = 0, c = 0;
		int s = 1000;
		
		for (a = 1; a < s / 3; a++) {
		    for (b = a; b < s / 2; b++) {
		        c = s - a - b;
		 
		        if (a * a + b * b == c * c) {
		            A = a;
		            B = b;
		            C = c;
		            return;
		        }
		    }
		}
	}

}
