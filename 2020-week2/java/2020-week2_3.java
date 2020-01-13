import java.util.Scanner;

public class BreakEvenPoint_1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fixedCost = sc.nextInt();
		int productionCost = sc.nextInt();
		int price = sc.nextInt();
		
		int profit = price-productionCost;
		if(profit<=0) {
			System.out.println(-1);
			return ;
		}
		int answer = fixedCost/profit+1;
		System.out.println(answer);
	}
}
