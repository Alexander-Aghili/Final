import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScoreCounter {

	private static int amountOfScores;
	
	public static void main(String[] args) {
		int scores = -1;
		while (scores == -1) {
			String file = getFileFromUser();
			scores = getScores(file);
			double averageScore = getAverageScores(scores, amountOfScores);
			if (scores != -1 && averageScore != 0) {
				System.out.println("Total Score: " + scores + "\nAverage Score: " + averageScore);
				return;
			}
			if (averageScore == 0) {
				scores = -1;
			}
		}
	}

	private static String getFileFromUser() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a file with scores: ");
		String userInput = input.nextLine().trim();
		
		return userInput;
		
	}
	
	//Return -1 if error
	private static int getScores(String file) {
		BufferedReader reader = null;
		int score = 0;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			
			while (line != null) {
				int lineScore = getScoresFromLine(line);
				if (lineScore == -1) {
					closeReader(reader);
					return lineScore;
				} else {
					score += lineScore;
				}
				line = reader.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("The file cannot be found. Ensure that you entered the correct path to a file that exists.\n");
			closeReader(reader);
			score = -1;
		} catch (IOException e) {
			System.out.println("There was an error within the file, please ensure the file is formatted correctly. \n");
			closeReader(reader);
			score = -1;
		}
		
		closeReader(reader);
		return score;
		
	}
	
	private static int getScoresFromLine(String line) {
		int lineScore = 0;
		while (line.length() > 0) {
			try {
				int nextSpace = line.indexOf(" ");
				if (nextSpace == -1) {
					amountOfScores++;
					lineScore += Integer.parseInt(line);
					return lineScore;
				} else {
					String singleScoreAsString = line.substring(0, nextSpace);
					lineScore += Integer.parseInt(singleScoreAsString);
					line = line.substring(nextSpace + 1);
					amountOfScores++;	
				}
			} catch (Exception e) {
				System.out.println("There has been an error. Ensure file contains only integer scores.\n");
				return -1;
			}
		}
		return lineScore;
	}
	
	private static double getAverageScores(int score, int averageScores) {
		try {
			return (double)score/ (double) averageScores;
		} catch (ArithmeticException e) {
			System.out.println("Ensure there is information added to the file. \n");
		}
		return 0;
	}
	
	private static void closeReader(BufferedReader reader) {
		try {
			if (reader != null)
				reader.close();
			//No need to explain issue closing, only time an issue would occur is if error already occurred.
		} catch (IOException e) {}
	}
	
}
