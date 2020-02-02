import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] tomatoes = new int[n][m][h];
        int[][][] curTomatoes = new int[n][m][h];
        int answer = 0;
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int curToken = Integer.parseInt(st.nextToken());
                    tomatoes[j][k][i] = curToken;
                    curTomatoes[j][k][i] = curToken;
                }
            }
        }
        boolean isImpossible = false;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoes[j][k][i] == 1) {
                        if (j - 1 >= 0 && tomatoes[j - 1][k][i] == 0) {
                            curTomatoes[j - 1][k][i] = tomatoes[j][k][i] + 1;
                            int[] coordinate = { j - 1, k, i };
                            q.offer(coordinate);
                        }
                        if (k - 1 >= 0 && tomatoes[j][k - 1][i] == 0) {
                            curTomatoes[j][k - 1][i] = tomatoes[j][k][i] + 1;
                            int[] coordinate = { j, k - 1, i };
                            q.offer(coordinate);
                        }
                        if (i - 1 >= 0 && tomatoes[j][k][i - 1] == 0) {
                            curTomatoes[j][k][i - 1] = tomatoes[j][k][i] + 1;
                            int[] coordinate = { j, k, i - 1 };
                            q.offer(coordinate);
                        }
                        if (j + 1 < n && tomatoes[j + 1][k][i] == 0) {
                            curTomatoes[j + 1][k][i] = tomatoes[j][k][i] + 1;
                            int[] coordinate = { j + 1, k, i };
                            q.offer(coordinate);
                        }
                        if (k + 1 < m && tomatoes[j][k + 1][i] == 0) {
                            curTomatoes[j][k + 1][i] = tomatoes[j][k][i] + 1;
                            int[] coordinate = { j, k + 1, i };
                            q.offer(coordinate);
                        }
                        if (i + 1 < h && tomatoes[j][k][i + 1] == 0) {
                            curTomatoes[j][k][i + 1] = tomatoes[j][k][i] + 1;
                            int[] coordinate = { j, k, i + 1 };
                            q.offer(coordinate);
                        }
                    } else if (tomatoes[j][k][i] == 0) {
                        isImpossible = true;
                    }
                }
            }
        }
        if (q.isEmpty() && !isImpossible) {
            System.out.print(0);
            return;
        } else if (q.isEmpty() && isImpossible) {
            System.out.print(-1);
            return;
        }
        while (!q.isEmpty()) {
            int[] curCoordinate = q.poll();
            int j = curCoordinate[0];
            int k = curCoordinate[1];
            int i = curCoordinate[2];
            if (j - 1 >= 0 && curTomatoes[j - 1][k][i] == 0) {
                curTomatoes[j - 1][k][i] = curTomatoes[j][k][i] + 1;
                answer = curTomatoes[j][k][i];
                int[] coordinate = { j - 1, k, i };
                q.offer(coordinate);
            }
            if (k - 1 >= 0 && curTomatoes[j][k - 1][i] == 0) {
                curTomatoes[j][k - 1][i] = curTomatoes[j][k][i] + 1;
                answer = curTomatoes[j][k][i];
                int[] coordinate = { j, k - 1, i };
                q.offer(coordinate);
            }
            if (i - 1 >= 0 && curTomatoes[j][k][i - 1] == 0) {
                curTomatoes[j][k][i - 1] = curTomatoes[j][k][i] + 1;
                answer = curTomatoes[j][k][i];
                int[] coordinate = { j, k, i - 1 };
                q.offer(coordinate);
            }
            if (j + 1 < n && curTomatoes[j + 1][k][i] == 0) {
                curTomatoes[j + 1][k][i] = curTomatoes[j][k][i] + 1;
                answer = curTomatoes[j][k][i];
                int[] coordinate = { j + 1, k, i };
                q.offer(coordinate);
            }
            if (k + 1 < m && curTomatoes[j][k + 1][i] == 0) {
                curTomatoes[j][k + 1][i] = curTomatoes[j][k][i] + 1;
                answer = curTomatoes[j][k][i];
                int[] coordinate = { j, k + 1, i };
                q.offer(coordinate);
            }
            if (i + 1 < h && curTomatoes[j][k][i + 1] == 0) {
                curTomatoes[j][k][i + 1] = curTomatoes[j][k][i] + 1;
                answer = curTomatoes[j][k][i];
                int[] coordinate = { j, k, i + 1 };
                q.offer(coordinate);
            }
            if (q.isEmpty()) {
                for (int x = 0; x < h; x++) {
                    for (int y = 0; y < n; y++) {
                        for (int z = 0; z < m; z++) {
                            if (curTomatoes[y][z][x] == 0) {
                                System.out.print(-1);
                                return;
                            }
                        }
                    }
                }
                System.out.print(answer);
            }
        }
    }
}