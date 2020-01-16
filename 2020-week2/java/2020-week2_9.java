package stack;
import java.util.Scanner;
import java.util.Stack;

public class Parenthesis_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			String str = sc.next();
			
			Stack<Character> stack = new Stack<>();
			boolean result = true;
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				
				if(c=='(') stack.add(c);
				else {
					if(stack.isEmpty()) {
						result = false;
						break;
					}
					stack.pop();
				}
			}
			
			if(!result) {
				System.out.println("NO");
				continue;
			}
			
			if(!stack.isEmpty()) {
				System.out.println("NO");
				continue;
			}
			
			System.out.println("YES");
		}
	}
}