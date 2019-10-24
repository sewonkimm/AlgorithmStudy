package week4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class week4_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.add(i+1);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            for(int i=0; i<k-1; i++){
                int num = q.remove();
                q.add(num);
            }

            answer.add(q.remove());
        }

        String ans = "<";
        for(int i=0; i<n; i++){
            ans += String.valueOf(answer.get(i)) + ", ";
        }
        ans = ans.substring(0, ans.length()-2) + ">";
        System.out.println(ans);
    }
}
