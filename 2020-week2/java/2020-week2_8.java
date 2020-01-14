package stack;
import java.util.Scanner;
import java.util.Stack;

public class Zero_10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<k; i++) {
			int number = sc.nextInt();
			if(number == 0) {
				if(!stack.isEmpty()) stack.pop();
				continue;
			}
			stack.add(number);
		}
		
		int answer = 0;
		while(!stack.isEmpty()) {
			answer += stack.pop();
		}
		
		System.out.println(answer);
	}
}
