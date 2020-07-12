import java.util.Scanner;

public class baseball_2503 {
	public static void check(int strike, int ball, int number, int[] numbers) {
		int first = number/100;
		int second = (number - (first)*100)/10;
		int third = number - first*100 - second*10;
		
		for(int i=123; i<988; i++) {
			int strikeCount = 0;
			int ballCount = 0;
			
			int Ifirst = i/100;
			int Isecond = (i - (Ifirst)*100)/10;
			int Ithird = i - Ifirst*100 - Isecond*10;
			
			if(Ifirst == 0 || Isecond == 0 || Ithird == 0) {
				continue;
			}

			if(Ifirst == first) {
				strikeCount ++;
			}
			
			if(Isecond == second) {
				strikeCount ++;
			}
			
			if(Ithird == third) {
				strikeCount++;
			}
			
			if(Ifirst == second || Ifirst == third) {
				ballCount ++;
			}
			
			if(Isecond == first || Isecond == third) {
				ballCount ++;
			}
			
			if(Ithird == first || Ithird == second) {
				ballCount++;
			}
			
			// System.out.println(strike + "," + ball + "," + number);
			// System.out.println(strikeCount + "," + ballCount + "," + i);

			if(strikeCount == strike && ballCount == ball) {
				// System.out.println(":"+i);
				if(numbers[i] == 0) numbers[i] = 1;
			}
			else {
				if(numbers[i] == 0) numbers[i] = -1;
				if(numbers[i] == 1) numbers[i] = -1;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int numbers[] = new int[988];
		
		int answer = 0;
		while(n-- > 0) {
			int number = sc.nextInt();
			int strike = sc.nextInt();
			int ball = sc.nextInt();
			
			if(strike == 3) {
				System.out.println(1);
				return;
			}
			
			check(strike, ball, number, numbers);
		}
		
		for(int i=123; i<988; i++) {
			int Ifirst = i/100;
			int Isecond = (i - (Ifirst)*100)/10;
			int Ithird = i - Ifirst*100 - Isecond*10;
			
			if(Ifirst == 0 || Isecond == 0 || Ithird == 0) {
				continue;
			}
			
			if(Ifirst != Isecond && Ifirst != Ithird && Isecond != Ithird) {
				if(numbers[i] == 1) {
					// System.out.println(i);
					answer ++;
				}
			}
		}
		
		System.out.println(answer);
	}
}

