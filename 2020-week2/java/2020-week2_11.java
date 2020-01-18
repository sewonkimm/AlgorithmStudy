package queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Queue<Integer> cards = new LinkedList<>();
		for(int i=0; i<n; i++) {
			int card = i+1;
			cards.add(card);
		}
		
		while(cards.size()>1) {
			cards.remove();
			int next = cards.remove();
			cards.add(next);
		}
		
		System.out.println(cards.poll());
	}
}
