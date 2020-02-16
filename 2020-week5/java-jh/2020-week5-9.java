import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        if (n == 1) {
            System.out.print(0);
            return;
        }
        if (n == 2) {
            System.out.println(3);
            return;
        }
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i++) {
            if (i % 2 == 1)
                continue;
            dp[i] += dp[i - 2] * 3;
            for (int j = 0; j < i - 3; j++) {
                dp[i] += dp[j] * 2;
            }
        }
        System.out.print(dp[n]);
    }
}