import java.util.Arrays;
import java.util.Scanner;

public class week7_6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int test_case=1; test_case<=t; test_case++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            float jungsu = 0;
            for(int i=n-k; i<n; i++){
                jungsu = (jungsu+arr[i])/2;
            }

            String answer = String.format("%.6f",jungsu);
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
