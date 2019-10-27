import java.util.Scanner;

public class week6_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        for(int j=1; j<=t; j++){
            String str = sc.nextLine();
            String answer = "";
            System.out.println(str);
            for(int i=0; i<str.length(); i++){
                if(i==0){
                    String c = String.valueOf(str.charAt(i)).toUpperCase();
                    answer += c;
                }
                if(str.charAt(i) == ' ') {
                    String c2 = String.valueOf(str.charAt(i + 1)).toUpperCase();
                    answer += c2;
                }
            }
            System.out.println("#"+j+" "+answer);
        }
    }
}