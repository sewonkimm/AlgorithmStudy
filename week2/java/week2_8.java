import java.util.PriorityQueue;

public class week2_8 {
    public static int solution(int[] scoville, int K){
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            q.offer(scoville[i]);
        }

        boolean result = false;
        int index = 0;
        while(!result){
            int a = q.poll();
            if(a<K){
                if(q.size()==0){
                    answer = -1;
                    break;
                }
                int b = q.poll();
                q.offer(a + (b*2));
                answer++;
            }else{
                result = true;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int[] arr = {1,2};
        int k = 3;
        System.out.println(solution(arr, k));
    }
}