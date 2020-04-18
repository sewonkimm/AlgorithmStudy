import java.util.Scanner;

public class Dial_5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		int[] time = new int[11];
		int[] alpha = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		for(int i=1; i<=10; i++) {
			time[i] = i + 1;
		}
		
		int answer = 0;
		for(int i=0; i<word.length(); i++) {
			int a = word.charAt(i) - 65;
			answer += time[alpha[a]];
		}
		System.out.println(answer);
	}
}
