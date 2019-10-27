import java.util.Scanner;

public class week6_6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int test_case=1; test_case<=t; test_case++){
            int k = sc.nextInt();

            int[][] arr = new int[k+1][(int)Math.pow(2, k)];
            for(int i=0; i<Math.pow(2, k); i++){
                arr[0][i] = sc.nextInt();
            }

            int answer = 0;
            for(int i=1; i<=k; i++){
                int len = arr[0].length/i;
                int a = 0;
                for(int j=0; j<len; j+=2){
                    if(arr[i-1][j] <= arr[i-1][j+1]){
                        arr[i][a] = arr[i-1][j+1];
                        answer += arr[i-1][j+1] - arr[i-1][j];
                    }else{
                        arr[i][a] = arr[i-1][j];
                        answer += arr[i-1][j] - arr[i-1][j+1];
                    }
                    a++;
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}