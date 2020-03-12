import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] relations;
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> committeeList;
    static int depth;

    static void rec(int num) {
        boolean isLastMember = true;
        committeeList.get(committeeList.size() - 1).add(num);
        isVisited[num] = true;
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i] && relations[i][num]) {
                rec(i);
                isLastMember = false;
            }
        }
        if (isLastMember)
            committeeList.add(new ArrayList<Integer>());
    }

    static int elect(ArrayList<Integer> committee) {
        int[][] committeeMembers = new int[committee.size() + 1][committee.size()];
        for (int i = 0; i < committee.size(); i++) {
            for (int j = 0; j < committee.size(); j++) {
                if (relations[committee.get(i)][committee.get(j)])
                    committeeMembers[i][j] = 1;
                else
                    committeeMembers[i][j] = Integer.MAX_VALUE - 1000;
            }
        }
        for (int i = 0; i < committee.size(); i++) {
            for (int j = 0; j < committee.size(); j++) {
                for (int k = 0; k < committee.size(); k++) {
                    if (j == i || k == i || j == k)
                        continue;
                    committeeMembers[j][k] = committeeMembers[j][k] < committeeMembers[j][i] + committeeMembers[i][k]
                            ? committeeMembers[j][k]
                            : committeeMembers[j][i] + committeeMembers[i][k];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < committee.size(); i++) {
            max = 0;
            for (int j = 0; j < committee.size(); j++) {
                if (committeeMembers[j][i] == Integer.MAX_VALUE - 1000)
                    continue;
                max = committeeMembers[j][i] > max ? committeeMembers[j][i] : max;
            }
            committeeMembers[committee.size()][i] = max;
        }

        int representative = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < committee.size(); i++) {
            if (committeeMembers[committee.size()][i] < min) {
                min = committeeMembers[committee.size()][i];
                representative = committee.get(i);
            }
        }
        return representative;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        relations = new boolean[n][n];
        isVisited = new boolean[n];
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer("");
        int x = 0;
        int y = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            relations[x][y] = true;
            relations[y][x] = true;
        }
        committeeList = new ArrayList<ArrayList<Integer>>();
        committeeList.add(new ArrayList<Integer>());
        // The number of committee
        for (int i = 0; i < n; i++) {
            if (!isVisited[i])
                rec(i);
        }
        committeeList.remove(committeeList.size() - 1);
        bw.write(committeeList.size() + "\n");
        // Elect representative of committee
        for (int i = 0; i < committeeList.size(); i++) {
            bw.write((elect(committeeList.get(i)) + 1) + "\n");
        }
        // Print
        bw.flush();
    }
}