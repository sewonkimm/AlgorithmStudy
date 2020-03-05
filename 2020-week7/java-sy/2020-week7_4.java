package codeup;

import java.util.*;

public class Remote_3120 {
	public static int[] visit;
	public static void bfs(int[] temp, int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		visit[a] = 1;
		
		while(!q.isEmpty()) {
			int now = q.remove();
			int count = visit[now]+1;
			
			if(now+1<temp.length && visit[now+1]==0) {
				q.add(now+1);
				visit[now+1]=count;
				if(now+1==b) break;
			}
			if(now-1>=0 && visit[now-1]==0) {
				q.add(now-1);
				visit[now-1]=count;
				if(now-1==b) break;
			}
			if(now+5<temp.length && visit[now+5]==0) {
				q.add(now+5);
				visit[now+5]=count;
				if(now+5==b) break;
			}
			if(now-5>=0 && visit[now-5]==0) {
				q.add(now-5);
				visit[now-5]=count;
				if(now-5==b) break;
			}
			if(now+10<temp.length && visit[now+10]==0) {
				q.add(now+10);
				visit[now+10]=count;
				if(now+10==b) break;
			}
			if(now-10>=0 && visit[now-10]==0) {
				q.add(now-10);
				visit[now-10]=count;
				if(now-10==b) break;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int[] temperature = new int[Math.max(a, b)+20];
		visit = new int[Math.max(a, b)+20];
		
		bfs(temperature, a, b);
		
		System.out.println(visit[b]-1);
	}
}
