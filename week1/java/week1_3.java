package week1;

import java.util.ArrayList;

public class week1_3 {
    public static int answer = 0;
    public static boolean[] v;
    public static ArrayList<Integer> a = new ArrayList<>();
    static boolean isPrime(int num){
        if(num == 1 || num == 0) return false;
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void go(char[] number, String str) {
        if(str.length() > number.length) return ;

        int n = 0;
        for(int i=0; i<str.length(); i++) {
            n += (str.charAt(i)-'0') * ((int) Math.pow(10, str.length()-1-i));
        }
        if(isPrime(n)) {
            boolean re = true;
            for(int i=0; i<a.size(); i++){
                if(a.get(i) == n){
                    re = false;
                    break;
                }
            }
            if(re){
                a.add(n);
                answer += 1;
            }
        }
        String temp = str;
        for(int i = 0; i < number.length; i++){
            if(v[i]==false){
                v[i] = true;
                str = temp + number[i];
                if(str.charAt(0) != '0') go(number, str);
                v[i] =false;
            }
        }
    }
    public static int solution(String numbers){
        char[] number = new char[numbers.length()];
        v = new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++) {
            number[i] = numbers.charAt(i);
        }
        go(number, "");
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution("011"));
    }
}