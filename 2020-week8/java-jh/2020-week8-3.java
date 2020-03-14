import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] relations = new int[n][n];
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(relations[i], 1000);
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer("");
        int x = 0;
        int y = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            relations[x][y] = 1;
            relations[y][x] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == i || k == i || j == k)
                        continue;
                    relations[j][k] = relations[j][k] < relations[j][i] + relations[i][k] ? relations[j][k]
                            : relations[j][i] + relations[i][k];
                }
            }
        }

        int number = 0;
        int index = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                number++;
                q.add(i);
                isVisited[i] = true;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    int max = 0;
                    for (int j = 0; j < n; j++) {
                        if (relations[cur][j] >= 1000)
                            continue;
                        max = relations[cur][j] > max ? relations[cur][j] : max;
                    }
                    if (max < min) {
                        min = max;
                        index = cur;
                    }
                    for (int j = 0; j < n; j++) {
                        if (!isVisited[j] && relations[cur][j] < 1000) {
                            q.add(j);
                            isVisited[j] = true;
                        }
                    }
                }
                list.add(index + 1);
                index = 0;
                min = Integer.MAX_VALUE;
            }
        }

        Collections.sort(list);
        System.out.println(number);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}