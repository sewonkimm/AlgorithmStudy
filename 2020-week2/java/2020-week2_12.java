import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class deque2_10866 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());   
		
		Deque<Integer> q = new ArrayDeque<>();
		PrintWriter bw = new PrintWriter(new OutputStreamWriter(System.out));

		for(int i=0; i<n; i++) {

			String[] command = br.readLine().split(" ");
			
			if(command[0].equals("push_back")) {
				int number = Integer.parseInt(command[1]);
				q.add(number);
			}
			
			else if(command[0].equals("push_front")) {
				int number = Integer.parseInt(command[1]);
				q.addFirst(number);
			}
			
			else if(command[0].equals("pop_front")) {
				if(q.isEmpty()) bw.println(-1);
				else {
					bw.println(q.pop());
				}
			}
			
			else if(command[0].equals("pop_back")) {
				if(q.isEmpty()) bw.println(-1);
				else {
					bw.println(q.pollLast());
				}
			}
			
			else if(command[0].equals("size")) {
				bw.println(q.size());
				
			}
			
			else if(command[0].equals("empty")) {
				if(q.isEmpty()) bw.println(1);
				else bw.println(0);
			}
			
			else if(command[0].equals("front")) {
				if(q.isEmpty()) bw.println(-1);
				else {
					bw.println(q.element());
				}
			}
			
			else if(command[0].equals("back")){
				if(q.isEmpty()) bw.println(-1);
				else {
					bw.println(q.peekLast());
				}
			}
		}	
		bw.close();
	}
}
