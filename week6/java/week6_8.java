import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class week6_8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int test_case=1; test_case<=t; test_case++){
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int answer = 0;

            for(int i=0; i<arr.length; i++){
                answer+=2*arr[i]+1;
                if(i>0){
                    answer -= arr[i-1];
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}
