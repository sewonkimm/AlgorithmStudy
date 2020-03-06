import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gap = Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
        int count = 0;
        while (gap >= 8) {
            count++;
            gap = Math.abs(gap - 10);
        }
        while (gap >= 3) {
            count++;
            gap = Math.abs(gap - 5);
        }
        while (gap != 0) {
            count++;
            gap -= 1;
        }
        System.out.print(count);
    }
}