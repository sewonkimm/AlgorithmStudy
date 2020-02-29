package dynamic;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair2 {
	int num;
	int count;
	
	Pair2(int num, int count){
		this.num = num;
		this.count = count;
	}
}

public class MakeOne_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		
		Pair2 start = new Pair2(n, 0);
		Queue<Pair2> q = new LinkedList<>();
		q.add(start);
		dp[n] = 0;
		
		while(!q.isEmpty()) {
			Pair2 now = q.remove();
			int num = now.num;
			int count = now.count;
			
			if(num%3==0 && num/3>=1) {
				if(dp[num/3]==0 || dp[num/3]==count) {
					q.add(new Pair2(num/3, count+1));
					dp[num/3] = count+1;
				}
			}
			
			if(num%2==0 && num/2>=1) {
				if(dp[num/2]==0 || dp[num/2]==count) {
					q.add(new Pair2(num/2, count+1));
					dp[num/2] = count+1;
				}
			}
			
			if(num-1>=1) {
				if(dp[num-1]==0 || dp[num-1]==count) {
					q.add(new Pair2(num-1, count+1));
					dp[num-1] = count+1;
				}
			}
			
			if(dp[1] != 0) break;
		}

		System.out.println(dp[1]);
	}
}
