import java.util.Scanner;

public class IamCooker_2953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] scoreArr = new int[5][4];
		
		int cooker = 0;
		int max = 0;
		for(int i=0; i<5; i++) {
			int sum = 0;
			for(int j=0; j<4; j++) {
				int score = sc.nextInt();
				sum += score;
			}
			if(max<sum) {
				cooker = i+1;
				max = sum;
			}
		}
		
		System.out.println(cooker);
		System.out.println(max);
	}
}
