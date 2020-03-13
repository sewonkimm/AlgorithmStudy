import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] nums = new long[n][n];
        if (n == 1) {
            bw.write(1 + " ");
            bw.flush();
            return;
        } else if (n == 2) {
            bw.write(1 + " " + "\n");
            bw.write(1 + " " + 1 + " ");
            bw.flush();
            return;
        }
        nums[0][0] = 1;
        nums[1][0] = 1;
        nums[1][1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    nums[i][j] = 1;
                    continue;
                }
                nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                bw.write(nums[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}