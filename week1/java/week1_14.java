class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] d = new int[n+1];
        d[1] = 1;
        d[2] = 2;
        for(int i=3; i<=n; i++){
            d[i] = (d[i-1] + d[i-2])%1000000007;
        }
        return d[n]%1000000007;
    }
}