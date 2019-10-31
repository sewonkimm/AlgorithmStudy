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
public class week7_2 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int bfs(int[][] room, int x, int y){
        boolean[][] check = new boolean[room.length][room.length];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));

        int count = 1;
        while(!q.isEmpty()){
            Pair now = q.remove();
            check[now.x][now.y] = true;

            int nowcnt = 0;
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=room.length || ny<0 || ny>=room.length) continue;
                if(check[nx][ny]) continue;
                if(room[now.x][now.y]+1 == room[nx][ny]){
                    nowcnt++;
                    q.add(new Pair(nx, ny));
                }
            }

            if(nowcnt>0){
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int test_case=1; test_case<=t; test_case++){
            int n = sc.nextInt();
            int[][] room = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    room[i][j] = sc.nextInt();
                }
            }

            int answer = 0;
            int maxcount = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    int nn = bfs(room, i, j);
                    if(nn > maxcount){
                        maxcount = nn;
                        answer = room[i][j];
                    }
                    if(nn == maxcount){
                        if(answer >= room[i][j]){
                            maxcount = nn;
                            answer = room[i][j];
                        }
                    }
                }
            }

            System.out.println("#"+test_case+" "+answer+" "+maxcount);
        }
    }
}
