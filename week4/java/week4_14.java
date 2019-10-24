import java.util.Scanner;

public class week4_14 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 0;
        for(int i=0; i<n; i++){
            String str = sc.next();
            boolean[] check = new boolean[26];
            boolean result = true;
            String[] c = str.split("");
            check[c[0].charAt(0)-97] = true;
            for(int j=1; j<c.length; j++){
                if(c[j-1].equals(c[j])){
                    continue;
                }else{
                    if(check[c[j].charAt(0)-97]){
                        result = false;
                        break;
                    }else{
                        check[c[j].charAt(0)-97] = true;
                    }
                }
            }
            if(result) answer++;
        }

        System.out.println(answer);
    }
}
