import java.util.Scanner;

public class week6_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int test_case=1; test_case<=t; test_case++){
            String[] arr = new String[10];
            for(int i=0; i<10; i++){
                arr[i] = sc.next();
            }

            int max = 0;
            int min = 1000001;
            for(int i=0; i<10; i++){
                String a = arr[i];
                int now = 0;
                for(int j=0; j<a.length(); j++){
                    now += (int)(a.charAt(j)-'0');
                }
                if(now >= max) max = now;
                if(now <= min) min = now;
            }

            System.out.println("#"+test_case+" "+max+" "+min);
        }
    }
}

