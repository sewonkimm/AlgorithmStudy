public class week2_10 {
    public static int solution(int[][] land){
        int[][] dp = new int[land.length][4];
        int max = 0;
        int index = 0;
        for(int i=0; i<4; i++){
            dp[0][i] = land[0][i];
            if(max < dp[0][i]){
                max = dp[0][i];
                index = i;
            }
        }

        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                if(j!=index){
                    dp[i][j] = max+land[i][j];
                }else{
                    int second = 0;
                    for(int k=0; k<4; k++){
                        if(k==index) continue;
                        if(second < dp[i-1][k]) second = dp[i-1][k];
                    }
                    dp[i][j] = second+land[i][j];
                }
            }
            for(int j=0; j<4; j++){
                if(max < dp[i][j]){
                    max = dp[i][j];
                    index = j;
                }
            }
        }

        int answer=0;
        for(int i=0; i<4; i++){
            answer = Math.max(answer, dp[land.length-1][i]);
        }

        return answer;
    }
    public static void main(String[] args){

    }
}