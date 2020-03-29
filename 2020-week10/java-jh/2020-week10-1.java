import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> coordinates = new ArrayList<ArrayList<Integer>>();
		StringTokenizer st = new StringTokenizer("");
		ArrayList<Integer> coordinate = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			coordinate = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			coordinate.add(Integer.parseInt(st.nextToken()));
			coordinate.add(Integer.parseInt(st.nextToken()));
			coordinates.add(coordinate);
		}
		Collections.sort(coordinates, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
				if (list1.get(0) > list2.get(0)) {
					return 1;
				} else if (list1.get(0).equals(list2.get(0))) {
					if (list1.get(1) > list2.get(1)) {
						return 1;
					} else if (list1.get(1).equals(list2.get(1))) {
						return 0;
					}
					return -1;
				}
				return -1;
			}
		});
		for (int i = 0; i < coordinates.size(); i++) {
			bw.write(coordinates.get(i).get(0) + " " + coordinates.get(i).get(1) + "\n");
		}
		bw.flush();
	}
}