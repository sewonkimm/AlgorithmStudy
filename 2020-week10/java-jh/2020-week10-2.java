import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] coordinates = new int[n][2];
        StringTokenizer st = new StringTokenizer("");
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coordinates, new Comparator<int[]>() {
            @Override
            public int compare(int[] coordinate1, int[] coordinate2) {
                if (coordinate1[1] > coordinate2[1]) {
                    return 1;
                } else if (coordinate1[1] == coordinate2[1] && coordinate1[0] > coordinate2[0]) {
                    return 1;
                } else if (coordinate1[0] == coordinate2[0] && coordinate1[1] == coordinate2[1]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            bw.write(coordinates[i][0] + " " + coordinates[i][1] + "\n");
        }
        bw.flush();
    }
}