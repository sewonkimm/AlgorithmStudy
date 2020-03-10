import java.io.*;
import java.util.*;

class Main {
    static char[][] picture;
    static int[][] coordinate = { { 1, -2, 1, 0 }, { 0, 0, 1, -2 } };

    static void rec(int x, int y) {
        picture[x][y] = '*';
        int nextX = x;
        int nextY = y;
        for (int i = 0; i < 4; i++) {
            nextX += coordinate[0][i];
            nextY += coordinate[1][i];
            if (nextX < 0 || nextY < 0 || nextX >= picture.length || nextY >= picture[0].length)
                continue;
            if (picture[nextX][nextY] == '_')
                rec(nextX, nextY);
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        picture = new char[10][10];
        String line = "";
        for (int i = 0; i < 10; i++) {
            line = br.readLine();
            for (int j = 0; j < 10; j++) {
                picture[i][j] = line.charAt(j);
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        // Recursion method(painting)
        if (picture[x][y] == '_')
            rec(x, y);
        // Print
        for (int i = 0; i < 10; i++) {
            bw.write(picture[i]);
            bw.write("\n");
        }
        bw.flush();
    }
}
