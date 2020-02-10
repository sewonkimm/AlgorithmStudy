import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int currentVal = 0;
		int temp = 0;
		int counter = 0;
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			int documentNum = sc.nextInt();
			int target = sc.nextInt() + 1;
			counter = 0;
			for (int j = 0; j < documentNum; j++) {
				int x = sc.nextInt();
				q.offer(x);
			}
			while (target >= 0) {
				for (int k = 0; k < documentNum; k++) {
					if (target == 0) {
						target = documentNum - 1;
					} else {
						target--;
					}
					temp = q.poll();
					if (temp > currentVal) {
						currentVal = temp;
						q.offer(temp);
						break;
					} else {
						if (k == documentNum - 1) {
							counter++;
							documentNum--;
							if (target == 0) {
								System.out.println(counter);
								target--;
							}
							currentVal = 0;
							break;
						} else {
							q.offer(temp);
						}
					}
				}
			}
			currentVal = 0;
			temp = 0;
			counter = 0;
			q.clear();
		}
		sc.close();
	}
}