import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MeetingPreparation_4508 {
	public static ArrayList<Integer> bfs(int start, boolean[] visit, int[][] distance) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;

		ArrayList<Integer> group = new ArrayList<>();
		group.add(start);
		while(!q.isEmpty()) {
			int p = q.remove();
			
			for(int i=0; i<distance.length; i++) {
				if(!visit[i] && distance[p][i] == 1) {
					q.add(i);
					visit[i] = true;
					group.add(i);
				}
			}
		}
		return group;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] visit = new boolean[n];
		int[][] d = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == j) d[i][j] = 0;
				else d[i][j] = 1000;
			}
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			d[a-1][b-1] = 1;
			d[b-1][a-1] = 1;
		}
		
		
		int count = 0;
		ArrayList<ArrayList> groups = new ArrayList<>();
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				count +=1 ;
				ArrayList temp = bfs(i, visit, d);
				groups.add(temp);
			}
		}
		
		for (int k = 0; k < n; ++k) {
		    for (int i = 0; i < n; ++i) {
		        for (int j = 0; j < n; ++j) {
		            if (d[i][j] > d[i][k] + d[k][j]) {
		                d[i][j] = d[i][k] + d[k][j];
		            }
		        }
		    }
		}
		
		System.out.println(count);
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			int max = -1;
			int person = -1;
			for(int j=0; j<n; j++) {
				if(d[i][j] > max && d[i][j]!=1000) {
					max = d[i][j];
					person = j;
				}
			}
			arr[i] = max;
		}
		
		ArrayList<Integer> a = new ArrayList<>();
		for(int k=0; k<groups.size(); k++) {
			int min = 100000;
			int answer = 0;
			for(int i=0; i<groups.get(k).size(); i++) {
				int p = (int) groups.get(k).get(i);
				if(min > arr[p]) {
					min = arr[p];
					answer = p;
				}
			}
			a.add(answer+1);
		}
		
		Collections.sort(a);
		
		for(int i=0; i<a.size(); i++) {
			System.out.println(a.get(i));
		}
	}
}
