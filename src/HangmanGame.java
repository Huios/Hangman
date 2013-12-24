import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// author - Tanaka Jimha

public class HangmanGame {

	// Used for reading data from the console.
	Scanner myInput;

	public HangmanGame() {
		// Set up our read-from-console.
		myInput = new Scanner(
				new BufferedReader(new InputStreamReader(System.in)));
	}


	public String readString(String prompt) {
		System.out.printf("%s ", prompt);
		String entered = myInput.nextLine();
		return entered;
	}

	public void play() {

		HangmanFileLoader data = new HangmanFileLoader();
		data.readFile("lowerwords.txt");

		// Getting input from the user
		String input2 = readString("How long do you want the word to be: ");
		int lengthOfWord = Integer.parseInt(input2);

		String input = readString("How many guesses: ");
		int maxGuess = Integer.parseInt(input);




		String secretWord = data.getRandomWord(lengthOfWord);

		// Creating a set to store each letter the user guesses
		Set<Character> guessedLetters = new HashSet<Character>();
		ArrayList<Character> wrongGuesses = new ArrayList<Character>();




		//Monitoring the number of guesses the user makes

		int guessesMade = 0;

		while(guessesMade < maxGuess) {



			for(int i = 0; i< secretWord.length(); i++) {

				if (guessedLetters.contains(secretWord.charAt(i))) {
					System.out.print(secretWord.charAt(i));

				}

				else System.out.print('_');
			} 

			System.out.println();

			System.out.println();


			System.out.println("Misses left " + (maxGuess - guessesMade));


			//Displaying the wrong guesses to the user
			
			System.out.print("Wrong guesses:"  );
			for(int i = 0; i < wrongGuesses.size(); i++ ) {
				System.out.print(wrongGuesses.get(i) + " ");
			}
			System.out.println();

			// Validating user input

			String input3 = readString("Guess a letter: ");



			if (secretWord.contains("" + input3.charAt(0))) {

				if (guessedLetters.contains(input3.charAt(0))) {
					System.out.println("You have already guessed that letter, please choose another one");
				}

				else { 
					System.out.println("That's correct!");
				}
			}
			else{
				if (wrongGuesses.contains(input3.charAt(0))) {
					System.out.println("You have already guessed that letter, please choose another one");
				}
				else {
					System.out.println("Sorry, that letter isn't in the word!");
					guessesMade ++;
					wrongGuesses.add(input3.charAt(0));
				}
			}

			guessedLetters.add(input3.charAt(0));

			System.out.println();

		}		
		boolean gameWon = true;

		for (int i = 0;i < secretWord.length(); i++ ) {
			if (!guessedLetters.contains(secretWord.charAt(i))) {
				gameWon = false;

			}


		}
		if (gameWon == true) {
			System.out.println("You won!");
		}
		else {
			System.out.println("Game over!");
		}

	}	 
}

