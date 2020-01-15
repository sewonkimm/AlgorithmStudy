import java.util.Scanner;

public class SugarDelivery2_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int answer = 5000;
		for(int i=0; i<=n/5; i++) {
			for(int j=0; j<=n/3; j++) {
				if(i*5+j*3>n) continue;
				if(i*5+j*3==n) answer = Math.min(answer, i+j);
			}
		}
		
		if(answer==5000) System.out.println(-1);
		else System.out.println(answer);
	}
}
