import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WordSort_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String[] words = new String[n];
		for(int i=0; i<n; i++) {
			words[i] = sc.next();
		}
		
		Arrays.sort(words, new Comparator<String>(){
			@Override
			public int compare(final String entry1, final String entry2) {
				if(entry1.length() < entry2.length()) return -1;
				else if(entry1.length() == entry2.length()) {
					return entry1.compareTo(entry2);
				}
				else return 1;
			}
		});
		
		System.out.println(words[0]);
		for(int i=1; i<n; i++) {
			if(words[i].equals(words[i-1])) continue;
			System.out.println(words[i]);
		}
	}
}
