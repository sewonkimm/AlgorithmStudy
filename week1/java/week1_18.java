package week1;

public class week1_18 {
    public static int fibonacci(int n){
        int[] fibo = new int[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        int i = 2;
        while(i<=n){
            fibo[i] = (fibo[i-1] + fibo[i-2])%1234567;
            i++;
        }
        return fibo[n]%1234567;
    }
    public static void main(String[] args){
        System.out.println(fibonacci(5));
    }
}
