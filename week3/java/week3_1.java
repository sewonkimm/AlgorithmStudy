public class week3_1 {
    public static int solution(int m, int n, int[][] puddles){
        int[][] dp = new int[n+1][m+1];
        int[][] map = new int[n+1][m+1];

        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==1 && j==1){
                    dp[i][j] = 1;
                }
                else{
                    if(map[i][j]==-1) continue;
                    else{
                        dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007;
                    }
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args){
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        System.out.println(solution(m,n,puddles));
    }
}