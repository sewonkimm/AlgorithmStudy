import java.io.*;
import java.util.*;

class Main {
    static int[][] blocks;
    static boolean[][] visited;
    static int answer;
    static int count;

    static void rec(int x, int y, boolean isStart) {
        visited[x][y] = true;
        count++;
        if (x - 1 >= 0 && !visited[x - 1][y] && blocks[x][y] == blocks[x - 1][y]) {
            rec(x - 1, y, false);
        }
        if (y - 1 >= 0 && !visited[x][y - 1] && blocks[x][y] == blocks[x][y - 1]) {
            rec(x, y - 1, false);
        }
        if (x + 1 < 7 && !visited[x + 1][y] && blocks[x][y] == blocks[x + 1][y]) {
            rec(x + 1, y, false);
        }
        if (y + 1 < 7 && !visited[x][y + 1] && blocks[x][y] == blocks[x][y + 1]) {
            rec(x, y + 1, false);
        }
        if (isStart) {
            if (count >= 3)
                answer++;
            count = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        count = 0;
        blocks = new int[7][7];
        visited = new boolean[7][7];
        StringTokenizer st = new StringTokenizer("");
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (!visited[i][j])
                    rec(i, j, true);
            }
        }
        System.out.print(answer);
    }
}