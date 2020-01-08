import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class wordSort_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = new String[n]; 
		
		for(int i=0; i<words.length; i++) {
			words[i] = sc.next();
		}
		
		Arrays.sort(words, new Comparator<String>() { 
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()) return 1;
				else if(o1.length() < o2.length()) return -1;
				else return o1.compareTo(o2);
			}
		});
		
		for(int i=0; i<words.length; i++) {
			if(i>=1 && words[i].equals(words[i-1])) continue;
			System.out.println(words[i]);
		}
	}
}
