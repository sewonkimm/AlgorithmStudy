import java.util.ArrayList;
import java.util.Scanner;

public class MissingParentheses_1541 {
	public static boolean isDigit(String str) {
		boolean result = true;
		for(int i=0; i<str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				result = false;
			}
		}
		return result;
	}
	public static int sum(String str) {
		String[] numbers = str.split("\\+");
		int sumResult = 0;
		for(int i=0; i<numbers.length; i++) {
			sumResult += Integer.parseInt(numbers[i]);
		}
		return sumResult;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		String[] minus = str.split("\\-");
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i=0; i<minus.length; i++) {
			if(isDigit(minus[i])) {
				numbers.add(Integer.parseInt(minus[i]));
			}
			else {
				numbers.add(sum(minus[i]));
			}
		}
		
		int answer = numbers.get(0);
		for(int i=1; i<numbers.size(); i++) {
			answer -= numbers.get(i);
		}
		
		System.out.println(answer);
	}
}