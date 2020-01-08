import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coinValue = new int[n];
		for(int i=0; i<n; i++) {
			coinValue[i] = sc.nextInt();
		}
		
		int index = n-1;
		int count = 0;
		while(k!=0) {
			if(k-coinValue[index]<0) {
				index--;
			}
			else if(k-coinValue[index]>0) {
				k -= coinValue[index];
				count++;
			}else {
				k -= coinValue[index];
				count++;
				break;
			}
		}
		
		System.out.println(count);
	}
}
