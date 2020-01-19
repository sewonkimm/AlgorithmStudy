package recursion;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Hanoi_11729 {
	public static int count = 0;
	public static ArrayList<String> str = new ArrayList<>();
	public static void move(int from, int to, int n) {
		StringBuilder sb = new StringBuilder();
		if(n==0) return; 
		count++;
		move(from, 6-from-to, n-1);
		str.add(sb.append(from).append(" ").append(to).toString());
		move(6-from-to, to, n-1);
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		move(1,3,n);
		bw.write(count+"\n");
		for(int i=0; i<str.size(); i++) {
			bw.write(str.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
