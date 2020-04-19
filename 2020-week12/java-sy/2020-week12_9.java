import java.util.Arrays;
import java.util.Scanner;

public class Router_2110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		int[] x = new int[n];
		for(int i=0; i<n; i++) {
			int home = sc.nextInt();
			x[i] = home;
		}
		Arrays.sort(x);
		
		if(c == 2) {
			System.out.println(x[n-1] - x[0]);
			return;
		}
		
		int left = 1;
		int right = x[n-1] - x[0];
				
		int answer = 0;
		while(left<=right) {
			int mid = (left + right) / 2;
			
			int count = 1;
			int base = x[0];
			for(int i=1; i<n; i++) {
				if(x[i] - base >= mid) {
					base = x[i];
					count++;
				}
			}
						
			if(count >= c) {				
				left = mid + 1;
				answer = mid;
			}
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
}
