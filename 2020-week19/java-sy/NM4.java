import java.util.Arrays;
import java.util.Scanner;

public class NM4 {
	public static int[] result = new int[10];
	public static boolean[] visit = new boolean[10];
	public static void go(int index, int n, int m, int a) {
		if(index == m) {
			for(int i=0; i<m; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=a; i<=n; i++) {
			result[index] = i;
			a = i;
			go(index+1, n, m, a);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		go(0,n, m, 1);
	}
} 
