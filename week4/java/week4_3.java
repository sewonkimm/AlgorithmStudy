package week4;

import java.util.Scanner;

public class week4_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] d = new int[n];
        d[0] = 1;
        d[1] = 2;
        for(int i=0; i<n; i++){
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n-1]);
    }
}
