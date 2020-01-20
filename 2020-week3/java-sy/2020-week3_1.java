import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			Queue<Integer> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int j=0; j<n; j++) {
				int importance = sc.nextInt();
				q.add(importance);
				pq.add(importance);
			}
						
			int answer = 0;
			while(!q.isEmpty()) {
				int now = q.peek();
				if(now>=pq.peek()) {
					answer++;
					q.remove();
					pq.remove();
					if(m==0) break;
					else m--;
				}else {
					q.remove();
					q.add(now);
					if(m==0) m = q.size()-1;
					else m--;
				}
			}
			
			System.out.println(answer);
		}
	}
}
