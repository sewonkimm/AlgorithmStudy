import java.util.Scanner;

public class week6_9 {
    public static int max = 0;
    public static void go(int[] arr, int index, int sum){
        if(index >= arr.length-1){
            if(max <= sum){
                max = sum;
            }
            return ;
        }

        index+=1;
        go(arr, index, sum+arr[index]);
        go(arr, index, sum*arr[index]);
        return ;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int test_case=0; test_case<=t; test_case++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            max = 0;
            go(arr, 0, arr[0]);
            System.out.println("#"+test_case+" "+max);
        }
    }
}
