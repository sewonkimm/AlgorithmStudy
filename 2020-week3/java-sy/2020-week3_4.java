import java.util.Scanner;
import java.util.Stack;

public class StackSequence_1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		int max=0;
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			
			if(max<num) {
				while(max<num) {
					max += 1;
					stack.add(max);
					answer.append("+\n");
				}
				stack.pop();
				answer.append("-\n");
			}
			else {
				if(stack.peek()==num) {
					stack.pop();
					answer.append("-\n");
				}else {
					answer.replace(0, answer.length(), "NO");
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}
