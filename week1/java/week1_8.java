import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i=heights.length-1; i>=0; i--){
            boolean re = false;
            for(int j=i-1; j>=0; j--){
                if(heights[i] < heights[j]){
                    q.add(j+1);
                    re = true;
                    break;
                }
            }
            if(!re) q.add(0);
        }

        for(int i=0; i<answer.length; i++){
            answer[i] = ((LinkedList<Integer>) q).removeLast();
        }

        return answer;
    }
}