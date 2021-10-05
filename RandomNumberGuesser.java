/*
 * Class: CMSC203 CRN: 22507
 * Assignment 2 
 * Instructor: Farnaz Eivaz
 * 
 * Description: This program ask the user to guess the random number that the computer has come up
 * with. 
    
 * Due: 9/14/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/
import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nextGuess = 0, lowGuess = 0, highGuess = 100;
		boolean correct = false;
		String nextRound = "";
		RNG number = new RNG();
		System.out.println("Enter your first guess");
		int randNum = number.rand();
	
		while (correct == false) {
			
			//Loop to repeatedly get guess and check the against the Random number generated
			//System.out.println(randNum);	
	        Scanner userInput = new Scanner(System.in);
			nextGuess = userInput.nextInt();
			System.out.println("Number of guesses is " + number.getCount());
			number.inputValidation(nextGuess, lowGuess, highGuess);
			highGuess = upperRange(nextGuess, highGuess, randNum);
			lowGuess = lowerRange(nextGuess, lowGuess, randNum);
			correct = highOrLow(nextGuess, randNum, lowGuess, highGuess);
				
			//To ask if you want to play another round
			if(correct == true) {
				number.resetCount();
				System.out.println("Try again? (yes or no)");
				Scanner nextInput = new Scanner(System.in);
				nextRound = nextInput.nextLine();
			}
			
			//to reset the values back too the beginning and generate a new random number
			if(correct == true && nextRound.equals("yes")) {
				correct = false;
				RNG number2 = new RNG();
				System.out.println("Enter your first guess");
				randNum = number.rand();
				nextGuess = 0; 
				lowGuess = 0; 
				highGuess = 100;
			}
		}
		
		System.out.println("Thanks for playing...");

	}
	
	public static boolean highOrLow(int x, int y, int z1, int z2) {
		//to let you know if your guess is too high or low 
		//& return true when you guess correctly
		boolean rightGuess = false;
		
		if(x < y) {
			System.out.println("Your guess is too low");
			System.out.println("Enter your next guess between " + z1 + " and " + z2);
		}
		else if(x > y) {
			System.out.println("Your guess is too high");
			System.out.println("Enter your next guess between " + z1 + " and " + z2);
		}
		else if(x == y) {
			System.out.println("Congratulations, you guessed correctly");
			rightGuess = true;
		}
		return rightGuess;
	}
	
	public static int upperRange(int x, int y, int z) {
		
		// to create a new upper limit for your guess
		if(x < y && x > z) {
			return x;
		}else {
			return y;
		}
		
	}
	
	public static int lowerRange(int x, int y, int z) {
			
		    // to create a new lower limit for your guess
			if(x > y && x < z) {
				return x;
			}else {
				return y;
			}	
	} 
}

// Abraham Lamidi wrote this code.