import java.util.HashSet;
import java.util.Scanner;

public class week7_8 {
    public static HashSet<String> set;
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};
    public static void dfs(String[][] info, int x, int y, int cnt, String str){
        if(cnt==7){
            set.add(str);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;
            dfs(info, nx, ny, cnt+1, str+info[nx][ny]);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        set = new HashSet<String>();
        for(int test_case=1; test_case<=t; test_case++){
            String[][] info = new String[4][4];

            set.clear();

            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    info[i][j] = sc.next();
                }
            }

            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    dfs(info, i, j, 1, info[i][j]);
                }
            }

            System.out.println("#"+test_case+" "+set.size());

        }
    }
}
