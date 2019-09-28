package week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class week4_5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] position = new int[m];
        for(int i=0; i<m; i++){
            position[i] = sc.nextInt();
        }

        LinkedList<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }

        int half = 0;
        int idx = 0;
        int answer = 0;
        for(int i=0; i<m; i++){

            if(q.size() % 2 == 0) half = (q.size()/2) - 1;
            else half = q.size()/2;

            for(int j=0; j<q.size(); j++){
                if(q.get(j) == position[i]){
                    idx = j;
                    break;
                }
            }

            if(half - idx >= 0){
                for(int j=0; j<idx; j++){
                    int first = q.pollFirst();
                    q.addLast(first);
                    answer++;
                }
            } else {
                for(int j=0; j<q.size() - idx; j++){
                    int last = q.pollLast();
                    q.addFirst(last);
                    answer ++;
                }
            }

            q.poll();
        }

        System.out.println(answer);
    }
}
