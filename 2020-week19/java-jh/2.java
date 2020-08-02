import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		// solve
		for (int i = n; i >= 4; i--) {
			String stringN = Integer.toString(i);
			boolean isFourOrSeven = true;
			for (int j = 0; j < stringN.length(); j++) {
				if (!(stringN.charAt(j) == '4' || stringN.charAt(j) == '7')) {
					isFourOrSeven = false;
					break;
				}
			}
			if (isFourOrSeven) {
				bw.append(Integer.toString(i));
				break;
			} else {
				continue;
			}
		}
		// print
		bw.flush();
	}
}
