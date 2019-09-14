public class week1_6 {
    public static int solution(int K, int[][] travel){
        int[][] dp = new int[travel.length][K+1];
        int answer = 0;

        dp[0][travel[0][0]] = travel[0][1];
        dp[0][travel[0][2]] = travel[0][3];
        for(int i=1; i<travel.length; i++){
            for(int j=0; j<=K; j++){
                if(dp[i-1][j] == 0) continue;
                if(j+travel[i][0] <= K){
                    dp[i][j+travel[i][0]] = Math.max(dp[i][j+travel[i][0]], dp[i-1][j] + travel[i][1]);
                    answer = Math.max(answer, dp[i][j+travel[i][0]]);
                }
                if(j+travel[i][2] <= K){
                    dp[i][j+travel[i][2]] = Math.max(dp[i][j+travel[i][2]], dp[i-1][j] + travel[i][3]);
                    answer = Math.max(answer, dp[i][j+travel[i][2]]);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){

    }
}