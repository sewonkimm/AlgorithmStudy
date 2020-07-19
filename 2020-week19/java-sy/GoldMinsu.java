import java.util.*;

public class GoldMinsu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        
        while(n > 3){
            String number = Integer.toString(n);
            
            boolean result = true;
            for(int i=0; i<number.length(); i++){
                int now = number.charAt(i) - '0';
                if(now == 4 || now == 7) continue;
                else{
                    result = false;
                    break;
                }
            }
            
            if(result) break;
            else n--;
        }
        
        System.out.println(n);
    }
}