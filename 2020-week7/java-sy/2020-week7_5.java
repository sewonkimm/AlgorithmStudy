import java.util.Scanner;

public class Change_3301 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		int i = 0;
		int answer = 0;
		while(n>0) {
			if(money[i] <= n) {
				answer++;
				n -= money[i];
			}else {
				if(i+1==money.length) break;
				i++;
			}
		}
		
		System.out.println(answer);
	}
}
