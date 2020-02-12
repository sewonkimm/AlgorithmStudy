import java.util.Scanner;

public class Blackjack_2798 {
	public static int answer = 0;
	public static void go(int[] cards, int index, int sum, int count, int m) {
		if(count==3) {
			if(sum<=m && answer<sum) {
				answer = sum;
				return;
			}
			else return;
		}
		if(index==cards.length) return;
		go(cards, index+1, sum+cards[index], count+1, m);
		go(cards, index+1, sum, count, m);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] cards = new int[n];
		for(int i=0; i<n; i++) {
			cards[i] = sc.nextInt();
		}
		
		go(cards, 0, 0, 0, m);
		
		System.out.println(answer);
	}
}
