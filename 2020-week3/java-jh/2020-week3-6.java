import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int IFN = 10000000;
        int answer = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] routes = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                routes[i][j] = IFN;
            }
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            routes[a - 1][b - 1] = c;
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                for (int k = 0; k < v; k++) {
                    routes[j][k] = Math.min(routes[j][k], routes[j][i] + routes[i][k]);
                }
            }
        }
        for (int i = 0; i < v; i++) {
            if (routes[i][i] != IFN) {
                if (answer != -1) {
                    answer = routes[i][i] < answer ? routes[i][i] : answer;
                } else {
                    answer = routes[i][i];
                }
            }
        }
        System.out.print(answer);
    }
}