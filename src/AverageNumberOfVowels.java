import java.util.Arrays;
import java.util.HashSet;

// Author- Tanaka Jimha

public class AverageNumberOfVowels {
	public static void main(String[] args) {
		HangmanFileLoader loader = new HangmanFileLoader();
		loader.readFile("lowerwords.txt");

		Character[] vowels = {'a', 'e', 'i', 'o', 'u'};

		HashSet<String> set = new HashSet<String>();

		for(int i = 4; i < 21; i++ ) {

			//populating the set with words of length i
			for(int k=0; k < 10000; k += 1) {
				set.add(loader.getRandomWord(i));
			}
			// iterating through every LETTER in the set and checking if it is a vowel
			int count = 0;

			for(String l : set) {

				for(int m = 0; m < l.length(); m++) {
					if (Arrays.asList(vowels).contains(l.charAt(m))) {
						count += 1;
					}
				}
			}

			int average = Math.round(count /set.size());

			System.out.printf("Average number of vowels in %d letter words = %d\n", i, average);

			set.clear();
		}
	}
}
