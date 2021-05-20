
public class Curiosity {
	
	public static void main(String[] args) {
		//Multiplication
		System.out.println(curiosity(6, 3));
		
	}
	public static int curiosity(int n, int m) {
		if (m <= 0) return 0;
		else return n + curiosity(n, m - 1);
	}

}
