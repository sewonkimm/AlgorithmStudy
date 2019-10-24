public class week2_2 {
    public static int[] solution(int[] prices){
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                cnt++;
                if(prices[i] > prices[j]) break;
            }
            answer[i] = cnt;
        }

        return answer;
    }
    public static void main(String[] args){

    }
}