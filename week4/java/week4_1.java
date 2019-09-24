import java.util.Arrays;
import java.util.Scanner;

public class week4_1 {
    public static void main(String[] ags){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = 0;
        for(int i=n-1; i>=0; i--){
            answer = Math.max(arr[i]*(n-i), answer);
        }
        System.out.println(answer);
    }
}
