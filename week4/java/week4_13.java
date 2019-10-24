import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class week4_13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] check = new boolean[n+1];

        int t = sc.nextInt();
        int[][] net = new int[n+1][n+1];
        for(int i=0; i<t; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            net[a][b] = net[b][a] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int answer = 0;
        while(!q.isEmpty()){
            int now = q.remove();
            check[now] = true;
            for(int i=1; i<=n; i++){
                if(1 == net[now][i]&& !check[i]) {
                    q.add(i);
                    check[i] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
