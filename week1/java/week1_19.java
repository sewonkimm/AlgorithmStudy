package week1;

import java.util.LinkedList;
import java.util.Queue;

public class week1_19 {
    public static boolean[] check;
    public static Queue<Integer> q = new LinkedList<>();
    public static void bfs(int n, int[][] computer, int v){
        q.add(v);
        check[v] = true;
        while(!q.isEmpty()){
            int cur = q.remove();
            check[cur] = true;
            for(int i=0; i<n; i++){
                if(check[i]==false && computer[cur][i] == 1){
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
    public static int solution(int n, int computers[][]){
        check = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(check[i]==false && computers[i][j] == 1){
                    bfs(n, computers, i);
                    answer ++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args){

    }
}