import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int[] currentProgression;

	static void makeProgression(int currentNumber, int depth, BufferedWriter bw) throws IOException {
		currentProgression[depth] = currentNumber;

		if (depth + 1 == m) {
			for (int i = 0; i < currentProgression.length; i++) {
				bw.append(currentProgression[i] + " ");
			}
			bw.append("\n");
			return;
		} else {
			for (int i = currentNumber; i <= n; i++) {
				makeProgression(i, depth + 1, bw);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		currentProgression = new int[m];

		// solve
		for (int i = 1; i <= n; i++) {
			makeProgression(i, 0, bw);
		}

		// print
		bw.flush();
	}
}