public class week3_5 {
    public static int solution(int n){
        int answer = 1;

        while(n!=1){
            if(n%2==0){
                n /= 2;
            }else{
                n = (n-1)/2;
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(5000));
    }
}