package week4;

import java.util.Scanner;

public class week4_7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str= sc.next();
        int[] alph = new int[26];

        for(int i=0; i<str.length(); i++){
            char a = str.charAt(i);
            if(65<=a && a<=90) alph[a-65] += 1;
            if(97<=a && a<=122) alph[a-97] += 1;
        }

        int answer = 0;
        for(int i=0; i<alph.length; i++){
            answer = Math.max(answer, alph[i]);
        }

        int cnt = 0;
        int k = 0;
        for(int i=0; i<alph.length; i++){
            if(answer == alph[i]){
                k = i;
                cnt++;
            }
        }

        if(cnt>1) System.out.println("?");
        else{
            char ans = (char) (65+k);
            System.out.println(ans);
        }
    }
}
