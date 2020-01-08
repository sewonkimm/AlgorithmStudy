import java.util.Scanner;

public class Fibonacci_2748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[] fibo = new long[n+1];
		fibo[0]=0;
		for(int i=1; i<n+1; i++) {
			if(i==1) {
				fibo[i] = 1;
				continue;
			}
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		System.out.println(fibo[n]);
	}
}