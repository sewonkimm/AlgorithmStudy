import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        dp[0] = 1;
        int coin = 0;
        for (int i = 0; i < n; i++) {
            coin = Integer.parseInt(br.readLine());
            for (int j = 1; j <= k; j++) {
                if (j >= coin)
                    dp[j] += dp[j - coin];
            }
        }
        System.out.print(dp[k]);
    }
}