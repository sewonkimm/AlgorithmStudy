import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideSeek_1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n==k) {
			System.out.println(0);
			return;
		}
		
		int[] location = new int[k*2+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		location[n] = 0;
		while(!q.isEmpty()) {
			int current = q.remove();
			
			if(current+1<location.length) {
				if(location[current+1]==0) {
					location[current+1] = location[current]+1;
					q.add(current+1);
				}
			}
			
			
			if(current-1>=0) {
				if(location[current-1]==0) {
					location[current-1] = location[current]+1;
					q.add(current-1);
				}
			}
			
			
			if(current*2<location.length) {
				if(location[current*2]==0) {
					location[current*2] = location[current]+1;
					q.add(current*2);
				}
			}
			
			
			
			if(location[k] != 0) break;
		}

		System.out.println(location[k]);
	}
}