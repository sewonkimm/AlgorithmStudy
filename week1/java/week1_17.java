class Solution {
    public int go(int start, int n){
        int sum = 0;
        for(int i=start; i<=n; i++){
            sum += i;
            if(sum == n) return 1;
            else if(sum > n) return 0;
        }
        return 0;
    }
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++){
            answer += go(i,n);
        }

        return answer;
    }
}