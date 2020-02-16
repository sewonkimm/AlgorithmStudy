import java.util.Arrays;
import java.util.Scanner;

public class FindAlpha_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] alpha = new int[26];
		
		Arrays.fill(alpha, -1);
		for(int i=0; i<s.length(); i++) {
			int c = (int)s.charAt(i) - 97;
			if(alpha[c]==-1) {
				alpha[c] = i;
			}
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(alpha[i] + " ");
		}
	}
}
