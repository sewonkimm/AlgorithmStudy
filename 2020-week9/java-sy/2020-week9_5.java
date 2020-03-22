import java.io.*;
import java.util.*;

public class NandM3_15651 {
	public static int[] p = new int[10];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//識情
    static void go(int index, int n, int m) throws IOException{
        if(index == m){
            for(int i = 0; i < m; i++){
                bw.write(p[i] + " ");
            }
            bw.write("\n");
            return ;
        }
        for(int i = 1; i <= n; i++){
            p[index] = i;
            go(index + 1, n, m);
        }
    }
    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //識情
    	String s = bf.readLine();
    	String[] str = s.split(" ");
    	int n = Integer.parseInt(str[0]);
    	int m = Integer.parseInt(str[1]);
        
        go(0, n, m);
        
        bw.flush();
        bw.close();
    }
}
