import java.util.*;

public class NandM2_15650 {
	public static int[] p = new int[10];
	public static void go(int n, int index, int cur, int m) {
		if(cur == m){
            for(int i = 0; i < m; i++){
                System.out.print(p[i] + " ");
            }
            System.out.println();
            return ;
        }
        if(index > n) return ;
        else p[cur] = index;
        go(n, index+1, cur + 1, m);
        go(n, index+1, cur, m);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		go(n, 1, 0, m);
	}
}
