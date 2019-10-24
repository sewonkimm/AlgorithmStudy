public class week2_3 {
    public static String solution(String number, int k){
        int idx=0;
        char max;
        StringBuilder answer = new StringBuilder();
        /*
            String answer = ""; 에서 + 를 해주는 것보다 빠르다.
        */

        for(int i=0; i<number.length()-k; i++){
            max = '0';
            for(int j=idx; j<=k+i; j++){
                if(max < number.charAt(j)){
                    max=number.charAt(j);
                    idx = j+1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
    public static void main(String[] args){
        System.out.println(solution("1924", 2));
    }
}