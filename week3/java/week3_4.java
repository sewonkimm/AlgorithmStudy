class Solution {
    public int solution(int num) {
        int answer = 0;
        int cnt = 0;
        long num2 = (long) num;
        while(num2 != 1){
            if(cnt>=500) break;
            if(num2%2==0) num2 /= 2;
            else num2 = num2 * 3 + 1;
            cnt ++;
        }
        if(num2 == 1) answer = cnt;
        else answer = -1;
        return answer;
    }
}