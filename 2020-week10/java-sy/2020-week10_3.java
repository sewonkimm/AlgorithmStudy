import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Croatia_2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		String[] w = word.split("");
		String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        List<String> alphaList = Arrays.asList(alpha);

		int index = 0;
		int answer = 0;
		while(true) {
			if(index == w.length) break;
			
			if(index == w.length - 1) {
				answer++;
				break;
			}
			
			if(index == w.length - 2) {
				String t = w[index] + w[index+1];
				if(alphaList.contains(t)) {
					answer++;
					break;
				}
				else {
					answer+=2;
					break;
				}
			}
			
			if(alphaList.contains(w[index]+w[index+1])) {
				answer++;
				index+=2;
			}
			else if(alphaList.contains(w[index]+w[index+1]+w[index+2])) {
				answer++;
				index+=3;
			}
			else {
				answer++;
				index+=1;
			}
		}
		
		System.out.println(answer);
	}
}
