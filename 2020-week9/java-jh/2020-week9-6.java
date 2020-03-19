import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw;
	static int n;
	static int m;
	static int[] nums;
	static int[] temp;

	static void rec(int num, int index) throws IOException {
		temp[index] = num;
		if (index == temp.length - 1) {
			for (int i = 0; i < temp.length; i++) {
				bw.write(temp[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = num; i < nums.length; i++) {
			if (nums[i] == 1)
				rec(i, index + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[10001];
		temp = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[Integer.parseInt(st.nextToken())] = 1;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 1)
				rec(i, 0);
		}
		bw.flush();
	}
}