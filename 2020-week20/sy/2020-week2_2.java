import java.util.Scanner;

public class Finger {
	public static int[] finger = {1, 2, 3, 4, 5, 4, 3, 2};
	//1, 5 : 1¹ø
	//2, 3, 4 : 2¹ø
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int injuredFinger = sc.nextInt();
		long n = sc.nextInt();
		
		if(injuredFinger == 1) {
			System.out.println((long)n*8);
			return;
		}
		if(injuredFinger == 5) {
			System.out.println((long)n*8+4);
			return;
		}
				
		long count = 8*((long)n/2);
		
		
		if(injuredFinger == 2) {
			if(n%2 == 0) count += 1;
			else count+=7;
		}
		
		if(injuredFinger == 3) {
			if(n%2 == 0) count += 2;
			else count+=6;
		}

		if(injuredFinger == 4) {
			if(n%2 == 0) count += 3;
			else count+=5;
		}
		
		System.out.println(count);
	}
}
