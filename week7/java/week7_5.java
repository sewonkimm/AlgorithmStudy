import java.util.Scanner;

public class week7_5 {
    public static int min;
    public static void go(int[] height, int index, int sum, int result){
        if(sum >= result){
            if(min > sum) min = sum;
            return ;
        }
        if(index > height.length-1) return ;

        go(height, index+1, sum+height[index], result);
        go(height, index+1, sum ,result);
        return ;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int test_case=1; test_case<=t; test_case++){
            int n = sc.nextInt();
            int b = sc.nextInt();

            int[] height = new int[n];

            for(int i=0; i<n; i++){
                height[i] = sc.nextInt();
            }

            min = 10000001;
            go(height, 0, 0, b);


            int answer = min - b;
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
