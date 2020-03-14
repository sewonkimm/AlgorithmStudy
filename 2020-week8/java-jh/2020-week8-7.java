import java.io.*;
import java.util.*;

public class Main {
    static int[] height;
    static int[] answer;

    static void rec(int index, int depth, int sum) {
        answer[depth] = height[index];
        sum += height[index];
        if (depth == 6 && sum == 100) {
            for (int i = 0; i < 7; i++) {
                System.out.println(answer[i]);
            }
            return;
        }
        if (depth == 6 && sum != 100)
            return;
        for (int i = index + 1; i <= depth + 3 && i < 9; i++) {
            rec(i, depth + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height = new int[9];
        answer = new int[7];
        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(height);
        for (int i = 0; i < 3; i++) {
            rec(i, 0, 0);
        }
    }
}