import java.util.Scanner;

public class week7_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[] alphabet = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};

        for(int test_case=1; test_case<=t; test_case++){
            String s = sc.next();
            int n = sc.nextInt();
            String[] arr = new String[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.next();
            }

            int answer = 0;
            for(int i=0; i<n; i++){
                String now = "";
                for(int j=0; j<arr[i].length(); j++){
                    String c = String.valueOf(alphabet[arr[i].charAt(j) - 97]);
                    now+= c;
                }
                if(now.equals(s)){
                    answer++;
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}
