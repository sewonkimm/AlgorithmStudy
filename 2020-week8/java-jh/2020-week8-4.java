import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static int[] seats;
    static boolean[] isReserved;

    static void rec(int waiting, int index) {
        if (waiting == 0) {
            count++;
            return;
        }
        for (int i = index + 2; i <= seats.length - (waiting * 2 - 1); i++) {
            rec(waiting - 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        seats = new int[n];
        isReserved = new boolean[n];
        for (int i = 0; i <= n - (k * 2 - 1); i++) {
            rec(k - 1, i);
        }
        System.out.print(count);
    }
}