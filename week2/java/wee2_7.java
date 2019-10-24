import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class week2_7 {
    public static int isMatch(String str1, String str2){
        int cnt = 0;

        for(int i=0; i< str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) cnt++;
        }

        return cnt;
    }
    public static int solution(String begin, String target, String[] words){
        boolean result = false;

        for(int i=0; i<words.length; i++){
            if(target.equals(words[i])) result = true;
        }
        if(!result) return 0;

        boolean[] check = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        int cnt = -1;

        while(!q.isEmpty()){
            String w = q.remove();
            cnt++;
            if(w.equals(target)) break;

            int c = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<words.length; i++){
                if(!check[i] && isMatch(w, words[i])==1){
                    c++;
                    temp.add(i);
                }
            }

            System.out.println(c);
            if(c>1){
                String min = "";
                int minc = 12345678;
                int ch = 0;
                for(int i=0; i<temp.size(); i++){
                    if(minc > isMatch(words[temp.get(i)], target)){
                        min = words[temp.get(i)];
                        minc = isMatch(words[temp.get(i)], target);
                        ch = i;
                    }
                }
                q.add(words[temp.get(ch)]);
                check[ch] = true;
            }
            else{
                q.add(words[temp.get(0)]);
                check[temp.get(0)] = true;
            }
        }

        return cnt;
    }
    public static void main(String[] args){
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        solution(begin, target, words);
    }
}