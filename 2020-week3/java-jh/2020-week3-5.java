import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times, (e1, e2) -> {
            if (e1[1] == e2[1]) {
                return Integer.compare(e1[0], e2[0]);
            } else {
                return Integer.compare(e1[1], e2[1]);
            }
        });
        int currentTime = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (times[i][1] >= currentTime && times[i][0] >= currentTime) {
                currentTime = times[i][1];
                count++;
            }
        }
        System.out.print(count);
    }
}