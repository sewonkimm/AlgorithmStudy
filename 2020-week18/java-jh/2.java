import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// init
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] results = new int[n][3];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			results[i][0] = Integer.parseInt(st.nextToken());
			results[i][1] = Integer.parseInt(st.nextToken());
			results[i][2] = Integer.parseInt(st.nextToken());
		}
		// check
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (j == i)
					continue;
				for (int k = 1; k < 10; k++) {
					if (k == i || k == j)
						continue;
					boolean isAnswer = true;
					for (int l = 0; l < results.length; l++) {
						int threeDigit = results[l][0] / 100;
						int twoDigit = (results[l][0] - threeDigit * 100) / 10;
						int oneDigit = (results[l][0] - threeDigit * 100 - twoDigit * 10);
						int strike = 0;
						int ball = 0;
						if (threeDigit == i)
							strike++;
						if (twoDigit == j)
							strike++;
						if (oneDigit == k)
							strike++;
						if (threeDigit == j || threeDigit == k)
							ball++;
						if (twoDigit == i || twoDigit == k)
							ball++;
						if (oneDigit == i || oneDigit == j)
							ball++;
						if (!(strike == results[l][1] && ball == results[l][2])) {
							isAnswer = false;
							break;
						}
					}
					if (isAnswer)
						answer++;
				}
			}
		}
		// print
		System.out.print(answer);
	}
}