import java.util.HashSet;

// Author- Tanaka Jimha


public class HangmanStats {
	public static void main(String[] args) {
		HangmanFileLoader loader = new HangmanFileLoader();
		loader.readFile("lowerwords.txt");

		HashSet<String> set = new HashSet<String>();
		for(int i = 4; i < 21; i++ ) {
			int best = 0;
			for(int j = 0; j < 100; j++) {
				for(int k=0; k < 10000; k += 1) {
					set.add(loader.getRandomWord(i));
				}
				best = Math.max(set.size(), best);
				set.clear();
			}
			System.out.printf("number of %d letter words = %d\n", i,  best);
		}


	}
}
