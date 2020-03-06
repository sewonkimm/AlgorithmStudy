import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] changes = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
        int answer = 0;
        for (int i = 0; i < changes.length; i++) {
            while (n / changes[i] > 0) {
                answer += n / changes[i];
                n %= changes[i];
            }
        }
        System.out.print(answer);
    }
}