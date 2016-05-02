import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Histogram {
	
	private int [] letterCount = new int [26];
	
	private FileReader inputStream = null;
	private FileWriter outputStream = null;
	
	public static void main(String[] args) throws IOException {
		Histogram histogram = new Histogram();
		histogram.readAndReturn();
	}
	
	public int[] readAndReturn() throws IOException {
		
		// Reading starts here
		try {
			inputStream = new FileReader("/Users/Rich/Google Drive/Studium/INFO 2/Week 17/random-chars.txt");
			int c; 

			// Conditions for lower case and upper case letters
			//@else ignore other symbols
			while((c = inputStream.read()) != -1) {
				if(c >= 65 && c <= 90) {
					c -= 65;
					letterCount[c]++;
				}
				else if (c >= 97 && c <= 122) {
					c -= 97;
					letterCount[c]++;
				}
				else {
					System.out.println("not a letter");
				}
			}
			
			/*
			 * Now the writing
			 */
			
			//create new file
			outputStream = new FileWriter("/Users/Rich/Google Drive/Studium/INFO 2/Week 17/frequency.txt");
			
			/*
			 * The algorithm for the loop
			 */
			
			//for every letter ...
			for(int numberOfLetter  = 0; numberOfLetter < letterCount.length; numberOfLetter++) {
				
				//... check if at least one was read by the reader ...
				if(letterCount[numberOfLetter] != 0) {
					
					String stringOfStars = ""; // *stars* needed to extend the histogram
					
					// ... if yes write first the letter to the file ...
					outputStream.write(numberOfLetter + 65);
					
					// ... and then add as much stars to the histogram as the number of times they were read.
					for(int numberOfStars = 0; numberOfStars < letterCount[numberOfLetter]; numberOfStars++) {
						
						stringOfStars += "*";
					}
					
					outputStream.write(" : " + stringOfStars + "\r\n");
				}
				else {
					System.out.println("No letters counted for: " + (char)(numberOfLetter + 65));
				}
			}
			
			
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
		
		return letterCount;
		
	}
}
