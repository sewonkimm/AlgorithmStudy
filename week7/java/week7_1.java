import java.util.Arrays;
import java.util.Scanner;

public class week7_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int test_case=1; test_case<=t; test_case++){
            int p = sc.nextInt();

            int[] arr = new int[p];
            for(int i=0; i<p; i++){
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int answer = 0;
            if(p==1){
                answer = arr[0] * arr[0];
            }else{
                answer = arr[0] * arr[arr.length-1];
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}
