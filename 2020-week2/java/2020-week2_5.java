import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ElectricWire_2565 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wireCount = sc.nextInt();
		
		int[][] position = new int[wireCount][2];
		for(int i=0; i<wireCount; i++) {
			position[i][0] = sc.nextInt();
			position[i][1] = sc.nextInt();
		}
		
		Arrays.sort(position, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

		int[] dp = new int[wireCount];
		Arrays.fill(dp, 1);
		for(int i=1; i<wireCount; i++) {
			for(int j=0; j<i; j++) {
				if(position[j][1]<position[i][1] && dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<wireCount; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(wireCount-max);
	}
}
