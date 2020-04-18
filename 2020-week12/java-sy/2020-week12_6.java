import java.util.Scanner;

public class Cmd_1032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String[] files = new String[n];
		for(int i=0; i<n; i++) {
			files[i] = sc.next();
		}
		
		String answer = "";
		for(int i=0; i<files[0].length(); i++) {
			boolean isSame = true;
			char c1 = files[0].charAt(i);
			for(int j=1; j<n; j++) {
				char c2 = files[j].charAt(i);
				if(c1 != c2) {
					isSame = false;
					break;
				}
			}
			if(isSame) answer += c1;
			else answer += "?";
		}
		
		System.out.println(answer);
	}
}
