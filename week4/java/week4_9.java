import java.util.Scanner;

public class week4_9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cur = 1;
        int answer = 0;
        while(cur<n){
            int sum = cur;
            String curStr = String.valueOf(cur);

            for(int i=0; i<curStr.length(); i++){
                sum += curStr.charAt(i)-'0';
            }

            if(sum == n){
                answer = cur;
                break;
            }

            cur++;
        }

        System.out.println(answer);
    }
}
