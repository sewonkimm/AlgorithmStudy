import java.util.Scanner;

public class Change_5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int change = 1000-n;
		int answer = 0;
		while(change > 0) {
			if(change >= 500) {
				change -= 500;
			}
			else if(change<500 && change>=100) {
				change -= 100;
			}
			else if(change<100 && change>=50) {
				change -= 50;
			}
			else if(change<50 && change>=10) {
				change -= 10;
			}
			else if(change<10 && change>=5) {
				change -= 5;
			}else {
				change -= 1;
			}
			answer +=1;
		}
		
		System.out.println(answer);
	}
}