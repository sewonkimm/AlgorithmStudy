import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer("");
        int[][] infos = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            infos[i][0] = Integer.parseInt(st.nextToken());
            infos[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] curInfo = new int[0];
        int count = 0;
        for (int i = 0; i < infos.length; i++) {
            curInfo = infos[i];
            for (int j = 0; j < infos.length; j++) {
                if (i == j)
                    continue;
                if (curInfo[0] < infos[j][0] && curInfo[1] < infos[j][1])
                    count++;
            }
            infos[i][2] = count + 1;
            count = 0;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < infos.length; i++) {
            bw.write(infos[i][2] + " ");
        }
        bw.flush();
    }
}