package queue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class AC_5430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			String p = sc.next();
			int n = sc.nextInt();
			String arr = sc.next();
			arr = arr.substring(1, arr.length()-1);
			String[] number = arr.split(",");
			
			Deque<Integer> dq = new ArrayDeque<>();
			
			for(int j=0; j<number.length; j++) {
				if(number[j].equals("")) continue;
				dq.add(Integer.parseInt(number[j]));
			}
			
			StringBuilder result = new StringBuilder();
			int state = 0;
			//0이면 앞에서 1이면 뒤에서 
			for(int j=0; j<p.length(); j++) {
				char c = p.charAt(j);
				
				if(c=='R') {
					state = state==0 ? 1 : 0;
				}
				else {
					if(dq.size()==0) {
						result.append("error");
						break;
					}
					if(state==0) {
						dq.pollFirst();
					}else {
						dq.pollLast();
					}
				}
			}
			
			if(result.toString().equals("error")) {
				System.out.println(result.toString());
			}
			else {
				result.append("[");
				if(state==0) {
					while(!dq.isEmpty()) {
						result.append(dq.peek());
						dq.removeFirst();
						if(!dq.isEmpty()) result.append(",");
					}
				}else {
					while(!dq.isEmpty()) {
						result.append(dq.peekLast());
						dq.removeLast();
						if(!dq.isEmpty()) result.append(",");
					}
				}
				result.append("]");
				System.out.println(result.toString());
			}
		}
	}
}
