import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class week4_12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(i%2==0) max.add(num);
            else min.add(num);

            if(!min.isEmpty()){
                if(max.peek() > min.peek()){
                    int maxn = max.peek();
                    int minn = min.peek();

                    max.remove(maxn);
                    min.remove(minn);

                    max.add(minn);
                    min.add(maxn);
                }
            }

            System.out.println(max.peek());
        }
    }
}
