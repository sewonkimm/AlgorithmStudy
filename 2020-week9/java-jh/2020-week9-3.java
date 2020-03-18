import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[10001];
		for (int i = 0; i < n; i++) {
			nums[Integer.parseInt(br.readLine())]++;
		}
		for (int i = 1; i < 10001; i++) {
			for (int j = 0; j < nums[i]; j++) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
	}
}