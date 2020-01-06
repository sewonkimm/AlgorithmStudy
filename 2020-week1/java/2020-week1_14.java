import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxHeap2_11279 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue q = new PriorityQueue<>(new Comparator<Integer>() { 
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});

		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			
			if(x==0) {
				if(q.isEmpty()) {
					System.out.println(0);
					continue;
				}
				System.out.println(q.poll());
			}
			else q.offer(x);
		}
	}
}
