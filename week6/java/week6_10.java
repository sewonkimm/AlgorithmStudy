import java.util.Scanner;

public class week6_7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int test_case=1; test_case<=t; test_case++){
            int n = sc.nextInt();
            int b = sc.nextInt();
            int e = sc.nextInt();

            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            int answer = 0;
            for(int i=0; i<n; i++){
                int now = arr[i];
                int k = 1;
                while(now <= b+e+1){
                    now = arr[i] * k;
                    if(now >= b-e && now <= b+e){
                        answer +=1;
                        break;
                    }
                    k++;
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}