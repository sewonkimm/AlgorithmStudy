import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static BufferedWriter bw;
	static int[] temp;

	static void rec(int index, int depth) throws IOException {
		temp[depth] = index;
		if (depth == m - 1) {
			for (int i = 0; i < temp.length; i++) {
				bw.write(temp[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = index + 1; i <= n - (m - (depth + 2)); i++) {
			rec(i, depth + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		temp = new int[m];
		for (int i = 1; i <= n - m + 1; i++) {
			rec(i, 0);
		}
		bw.flush();
	}
}