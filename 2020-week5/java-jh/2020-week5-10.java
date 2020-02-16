import java.io.*;
import java.util.*;

class Main {
    static BufferedWriter bw;
    static int[] nums;

    static void rec(int n, int count) throws IOException {
        if (count == nums.length) {
            for (int i = 0; i < nums.length; i++) {
                bw.write(nums[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            nums[count] = i;
            rec(n, count + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nums = new int[m];
        rec(n, 0);
        bw.flush();
    }
}