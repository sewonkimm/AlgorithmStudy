package bruteforce;
import java.util.Scanner;

public class HanSu_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<100) {
			System.out.println(n);
			return;
		}
		
		int answer = 99;
		int cur = 100;
		while(cur<=n) {
			int first = cur/100;
			int second = (cur%100)/10;
			int third = cur%10;
			
			if(third-second == second-first) answer+=1;
			cur+=1;
		}
		
		System.out.println(answer);
	}
}
