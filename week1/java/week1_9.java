import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            q.add(priorities[i]);
        }

        System.out.println(q);
        loop : while(!q.isEmpty()){
            int i=0;
            boolean re = true;
            for(int j=i+1; j<q.size(); j++){
                if(((LinkedList<Integer>) q).get(i) < ((LinkedList<Integer>) q).get(j)){
                    q.add(q.remove());
                    location--;
                    if(location<0) location = q.size()-1;
                    re = false;
                    break;
                }
            }
            if(re){
                q.remove();
                location--;
                answer++;
                if(location<0) break loop;
            }


        }
        return answer;
    }
}