import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int temp = 0;
        char[][] board = new char[n][m];
        char[][] standard = new char[n][m];
        String line = "";
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i + j) % 2 == 0)
                    standard[i][j] = 'W';
                else
                    standard[i][j] = 'B';
            }
        }
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (board[k][l] == standard[k][l])
                            temp++;
                    }
                }
                min = temp < min ? temp : min;
                temp = 0;
            }
        }
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (board[k][l] != standard[k][l])
                            temp++;
                    }
                }
                min = temp < min ? temp : min;
                temp = 0;
            }
        }
        System.out.print(min);
    }
}