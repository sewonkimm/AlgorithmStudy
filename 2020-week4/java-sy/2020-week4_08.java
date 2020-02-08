import java.util.ArrayList;
import java.util.Scanner;

public class Find_1786 {
	public static ArrayList<Integer> ans = new ArrayList<>();
	public static void getPi(int[] pi, char[] p_arr) {
		int j = 0;
		for(int i=1; i<p_arr.length; i++) {
			while(j>0 && p_arr[j]!=p_arr[i]) {
				j=pi[j-1];
			}
			if(p_arr[i]==p_arr[j]) {
				j++;
				pi[i] = j;
			}
		}
	} 
	
	public static void kmp(char[] p_arr, char[] t_arr, int[] pi) {
		int j = 0;
		for(int i=0; i<t_arr.length; i++) {
			while(j>0 && p_arr[j]!=t_arr[i]) {
				j=pi[j-1];
			}
			if(t_arr[i]==p_arr[j]) {
				if(j==p_arr.length-1) {
					ans.add(i-p_arr.length+1);
					j=pi[j];
				}else {
					j++;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();
		String p = sc.nextLine();
		
		int[] pi = new int[p.length()];
		char[] p_arr = p.toCharArray();
		char[] t_arr = t.toCharArray();
		getPi(pi, p_arr);
		kmp(p_arr, t_arr, pi);

		System.out.println(ans.size());
		for(int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i)+1 + " ");
		}
	}
}
