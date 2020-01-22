package dfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NandM1_15649 {
	public static ArrayList<Integer> result = new ArrayList<>();
	public static boolean[] visit;
	public static void go(int[] arr, int m, int index) {
		visit[index] = true;
		result.add(arr[index]);
		
		if(result.size() == m) {
			for(int i=0; i<result.size(); i++) {
				System.out.print(result.get(i) + " ");
			}
			System.out.println();
			return ;
		}
		
		if(index >= arr.length) return;
		
		for(int i=0; i<arr.length; i++) {
			if(visit[i]) continue;
			go(arr, m, i);
			visit[i] = false;
			result.remove(result.size()-1);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			go(arr, m, i);
			Arrays.fill(visit, false);
			result.clear();
		}
	}
}

