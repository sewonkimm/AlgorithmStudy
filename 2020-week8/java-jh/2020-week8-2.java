import java.io.*;
import java.util.*;

class Main {
    static int[][] candies;

    static void cal(int x, int y) {
        if (x - 1 >= 0 && y - 1 >= 0) {
            int horizentalDirection = candies[x][y] + candies[x][y - 1];
            int verticalDirection = candies[x][y] + candies[x - 1][y];
            candies[x][y] = horizentalDirection > verticalDirection ? horizentalDirection : verticalDirection;
        } else if (x - 1 >= 0) {
            candies[x][y] += candies[x - 1][y];
        } else if (y - 1 >= 0) {
            candies[x][y] += candies[x][y - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        candies = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                candies[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cal(i, j);
            }
        }
        System.out.print(candies[n - 1][m - 1]);
    }
}