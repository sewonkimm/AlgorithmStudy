//import java.io.*;
//import java.util.*;
//
//public class Main {
//	static int isPalindrome(int [] nums, int from, int to) {
//		while(from < to) {
//			if(nums[from++] != nums[to--]) return 0;
//		}
//		return 1;
//	}
//	
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int n = Integer.parseInt(br.readLine());
//		int [] nums = new int[n + 1];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i = 1; i <= n; i++) {
//			nums[i] = Integer.parseInt(st.nextToken());
//		}
//		int m = Integer.parseInt(br.readLine());
//		int from;
//		int to;
//		for(int i = 0; i < m; i++) {
//			st = new StringTokenizer(br.readLine());
//			from = Integer.parseInt(st.nextToken());
//			to = Integer.parseInt(st.nextToken());
//			bw.write(isPalindrome(nums, from ,to) + "\n");
//		}
//		bw.flush();
//	}
//}

//import java.io.*;
//import java.util.*;
//
//public class Main {
//	static int [][] dp;
//	
//	static void isPalindrome(int [] nums, int from, int to) {
//		int i = 0;
//		while(from + i < to - i) {
//			if(nums[from + i] != nums[to - i]) return;
//			i++;
//		}
//		i = 0;
//		while(from + i <= to - i) {
//			dp[from + i][to - i] = 1;
//			i++;
//		}
//		return;
//	}
//	
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int n = Integer.parseInt(br.readLine());
//		dp = new int[n + 1][n + 1];
//		int [] nums = new int[n + 1];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i = 1; i <= n; i++) {
//			nums[i] = Integer.parseInt(st.nextToken());
//		}
//		for(int i = n; i >= 1; i--) {
//			for(int j = n; j >= 1; j--) {
//				if(dp[i][j] != 1) isPalindrome(nums, i, j);
//			}
//		}
//		int m = Integer.parseInt(br.readLine());
//		int from;
//		int to;
//		for(int i = 0; i < m; i++) {
//			st = new StringTokenizer(br.readLine());
//			from = Integer.parseInt(st.nextToken());
//			to = Integer.parseInt(st.nextToken());
//			bw.write(dp[from][to] + "\n");
//		}
//		bw.flush();
//	}
//}

import java.io.*;
import java.util.*;

public class Main {
	static int [][] dp;
	
	static void isPalindrome(int [] nums, int from, int to) {
		int i = 0;
		while(from + i < to - i) {
			if(nums[from + i] != nums[to - i]) return;
			i++;
		}
		i = 0;
		while(from + i <= to - i) {
			dp[from + i][to - i] = 1;
			i++;
		}
		return;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][n + 1];
		int [] nums = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = n; i >= 1; i--) {
			for(int j = n; j >= 1; j--) {
				if(dp[i][j] != 1) isPalindrome(nums, i, j);
			}
		}
		int m = Integer.parseInt(br.readLine());
		int from;
		int to;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			bw.write(dp[from][to] + "\n");
		}
		bw.flush();
	}
}