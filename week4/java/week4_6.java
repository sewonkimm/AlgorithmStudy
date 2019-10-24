package week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class week4_6 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static void bfs(int x, int y, int[][] map){
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(x, y);
        q.add(p);
        map[x][y] = 0;

        while(!q.isEmpty()){
            x = q.element().x;
            y = q.element().y;
            q.remove();

            for(int i=0; i<4; i++){
                int a = x + dx[i];
                int b = y + dy[i];
                if (0 <= a && a < map.length && 0 <= b && b < map[0].length) {
                    if (map[a][b] == 1) {
                        Pair newPair = new Pair(a, b);
                        q.add(newPair);
                        map[a][b] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int answer = 0;

            int[][] map = new int[n][m];
            for(int i=0; i<k; i++){
                int y = sc.nextInt();
                int x = sc.nextInt();
                map[x][y] = 1;
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] == 1){
                        bfs(i, j, map);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }

    }
}
