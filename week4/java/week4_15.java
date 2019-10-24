import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class week4_15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while(true) {
            String str = br.readLine();
            if(str.charAt(0)=='.') break;
            list.add(str);
        }

        Iterator iter = list.iterator();

        while(iter.hasNext()) {
            String str = (String)iter.next();

            if(str.charAt(0)=='.') break;

            Stack<Character> stack = new Stack<Character>();

            boolean result = true;
            for(int i = 0; i < str.length() ; i++) {
                if(str.charAt(i)=='(') {
                    stack.push(str.charAt(i));
                }
                else if(str.charAt(i)==')') {
                    if(!stack.isEmpty()){
                        if(!(stack.peek()=='(')) break;
                        else stack.pop();
                    }else{
                        result = false;
                        break;
                    }
                }
                else if(str.charAt(i)=='[') {
                    stack.push(str.charAt(i));
                }
                else if(str.charAt(i)==']') {
                    if(!stack.isEmpty()){
                        if(!(stack.peek()=='[')) break;
                        else stack.pop();
                    }else{
                        result = false;
                        break;
                    }
                }
            }

            if(stack.isEmpty() && result)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
