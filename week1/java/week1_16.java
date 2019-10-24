import java.util.Queue;
import java.util.LinkedList;
class Solution {
    boolean solution(String s) {
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '('){
                q.add(cur);
            }else{
                if(q.size()!=0) ((LinkedList<Character>) q).removeLast();
                else return false;
            }
        }

        if(q.size() == 0) return true;
        else return false;
    }
}