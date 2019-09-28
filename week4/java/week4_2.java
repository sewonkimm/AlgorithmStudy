package week4;

import java.util.Scanner;

public class week4_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 0;
        while(n > 0){
            answer++;
            String str = Integer.toString(answer);

            if(str.contains("666")) n--;
        }

        System.out.println(answer);
    }
}
