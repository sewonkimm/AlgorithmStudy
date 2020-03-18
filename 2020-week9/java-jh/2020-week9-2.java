import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = 666;
		int count = 0;
		while (count < n) {
			String numStr = Integer.toString(num);
			if (numStr.contains("666"))
				count++;
			num++;
		}
		System.out.print(num - 1);
	}
}