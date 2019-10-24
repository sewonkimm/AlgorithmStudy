package week1;

import java.util.Arrays;

public class week1_2 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;
        while (true) {
            if(i>=j){
                if(i==j) answer++;
                break;
            }
            if(people[i] + people[j] <= limit){
                answer++;
                i++;
                j--;
            }else{
                answer++;
                j--;
            }
            System.out.println(i);
            System.out.println(j);
            System.out.println(answer);
        }
        return answer;
    }
    public static void main(String[] args){
        int[] arr = {70, 50, 80, 50};
        System.out.println(solution(arr, 100));
    }
}
