import java.util.Scanner;

public class FilmDirector_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int title = 666;
		int count = 1;
		
		while(count!=n) {
			title += 1;
			if(String.valueOf(title).contains("666")) {
				count += 1;
			}
		}
		
		System.out.println(title);
	}
}
