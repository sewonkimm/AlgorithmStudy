import java.io.*;
import java.util.*;

class Edge {
    int to;
    int distance;

    Edge(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}

class Main {
    static ArrayList<Edge>[] al;
    static boolean[] visited;
    static int max = 0;
    static int firstNode;

    static void dfs(int curNode, int acc) {
        boolean isEnd = true;
        visited[curNode] = true;
        for (int i = 0; i < al[curNode].size(); i++) {
            Edge temp = al[curNode].get(i);
            if (!visited[temp.to]) {
                isEnd = false;
                visited[temp.to] = true;
                dfs(temp.to, acc + temp.distance);
            }
        }
        if (isEnd) {
            if (acc > max) {
                max = acc;
                firstNode = curNode;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        al = (ArrayList<Edge>[]) new ArrayList[v + 1];
        visited = new boolean[v + 1];
        for (int i = 0; i < v + 1; i++) {
            al[i] = new ArrayList<Edge>();
        }
        StringTokenizer st = new StringTokenizer(" ");
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            while (to != -1) {
                int distance = Integer.parseInt(st.nextToken());
                al[nodeNum].add(new Edge(to, distance));
                to = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 0);
        max = 0;
        for (int i = 0; i < v + 1; i++) {
            visited[i] = false;
        }
        dfs(firstNode, 0);
        System.out.print(max);
    }
}