import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] tomatoes = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Stack<int[]> s = new Stack<int[]>();
        int answer = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j] == 1) {
                    if (i - 1 >= 0 && tomatoes[i - 1][j] == 0) {
                        int[] coordinate = { i - 1, j };
                        s.push(coordinate);
                    }
                    if (j - 1 >= 0 && tomatoes[i][j - 1] == 0) {
                        int[] coordinate = { i, j - 1 };
                        s.push(coordinate);
                    }
                    if (i + 1 < n && tomatoes[i + 1][j] == 0) {
                        int[] coordinate = { i + 1, j };
                        s.push(coordinate);
                    }
                    if (j + 1 < m && tomatoes[i][j + 1] == 0) {
                        int[] coordinate = { i, j + 1 };
                        s.push(coordinate);
                    }
                } else if (tomatoes[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (s.isEmpty()) {
            if (flag) {
                System.out.println(answer);
                return;
            } else {
                System.out.print(--answer);
                return;
            }
        } else {
            answer++;
        }
        Stack<int[]> newS = new Stack<int[]>();
        while (!s.isEmpty()) {
            int[] curCoordinate = s.pop();
            int i = curCoordinate[0];
            int j = curCoordinate[1];
            tomatoes[i][j] = 1;
            if (i - 1 >= 0 && tomatoes[i - 1][j] == 0) {
                tomatoes[i - 1][j] = 1;
                int[] coordinate = { i - 1, j };
                newS.push(coordinate);
            }
            if (j - 1 >= 0 && tomatoes[i][j - 1] == 0) {
                tomatoes[i][j - 1] = 1;
                int[] coordinate = { i, j - 1 };
                newS.push(coordinate);
            }
            if (i + 1 < n && tomatoes[i + 1][j] == 0) {
                tomatoes[i + 1][j] = 1;
                int[] coordinate = { i + 1, j };
                newS.push(coordinate);
            }
            if (j + 1 < m && tomatoes[i][j + 1] == 0) {
                tomatoes[i][j + 1] = 1;
                int[] coordinate = { i, j + 1 };
                newS.push(coordinate);
            }
            if (s.isEmpty() && !newS.isEmpty()) {
                answer++;
                while (!newS.isEmpty()) {
                    s.push(newS.pop());
                }
            } else if (s.isEmpty() && newS.isEmpty()) {
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        if (tomatoes[x][y] == 0) {
                            System.out.print(-1);
                            return;
                        }
                    }
                }
                System.out.print(answer);
            }
        }
    }
}