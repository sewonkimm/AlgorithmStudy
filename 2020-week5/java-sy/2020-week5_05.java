import java.util.Scanner;

public class Decomposition_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int number = 1;
		int answer = 0;
		while(number < n) {
			int cons = number;
			String numToStr = String.valueOf(number);
			for(int i=0; i<numToStr.length(); i++) {
				int cur = numToStr.charAt(i) - '0';
				cons += cur;

			}
			
			if(cons==n) {
				answer = number;
				break;
			}
			number++;
		}
		
		System.out.println(answer);
	}
}
