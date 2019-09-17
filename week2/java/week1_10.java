import java.util.ArrayList;

public class week1_10 {
    public static int solution(int bridge_length, int weight, int[] truck_weights){
        int totalTime = 1;
        int index = 1;
        int finished = 0;

        int[] startTime = new int[truck_weights.length];
        ArrayList<Integer> nowq = new ArrayList<>();
        nowq.add(0);
        startTime[0] = 1;

        while(finished < truck_weights.length){
            totalTime++;
            int now_weights = 0;

            for(int i=0; i<nowq.size(); i++){
                if(bridge_length - (totalTime - startTime[nowq.get(i)]) == 0){
                    nowq.remove(i);
                    finished += 1;
                }
            }

            if(index < truck_weights.length){
                for(int i=0; i<nowq.size(); i++) {
                    now_weights += truck_weights[nowq.get(i)];
                }
                if(now_weights+truck_weights[index] <= weight){
                    nowq.add(index);
                    startTime[index] = totalTime;
                    index++;
                }
            }


        }
        return totalTime;
    }
    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck = {7,4,5,6};

        System.out.println(solution(bridge_length, weight, truck));
    }
}