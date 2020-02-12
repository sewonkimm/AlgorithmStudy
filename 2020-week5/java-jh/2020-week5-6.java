import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        int who = 0;
        int score = 0;
        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            int curScore = 0;
            for (int j = 0; j < 4; j++) {
                curScore += Integer.parseInt(st.nextToken());
            }
            if (curScore > score) {
                score = curScore;
                who = i;
            }
        }
        System.out.print(who + " " + score);
    }

}