import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] time = new int[n];
		for(int i=0; i<n; i++) {
			time[i] = sc.nextInt();
		}
		
		Arrays.sort(time);
		
		int answer = time[0];
		for(int i=1; i<n; i++) {
			time[i] += time[i-1];
			answer += time[i];
		}
		
		System.out.println(answer);
	}
}