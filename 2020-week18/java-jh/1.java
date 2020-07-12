import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		User[] users = new User[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			users[i] = new User(age, name);
		}

		// sort
		Arrays.sort(users, new UserComparator());

		// print
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < users.length; i++) {
			bw.append(users[i].getAge() + " " + users[i].getName() + "\n");
		}
		bw.flush();
	}
}

class User {
	private int age;
	private String name;

	User(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}
}

class UserComparator implements Comparator<User> {
	@Override
	public int compare(User user1, User user2) {
		if (user1.getAge() > user2.getAge()) {
			return 1;
		} else if (user1.getAge() < user2.getAge()) {
			return -1;
		} else {
			return 0;
		}
	}
}