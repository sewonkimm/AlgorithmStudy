import java.io.*;
import java.util.*;

public class LocationSort_11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int[][] location = new int[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			location[i][0] = Integer.parseInt(st.nextToken());
			location[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(location, new Comparator<int[]>() {
			@Override
			public int compare(int[] location1, int[] location2) {
				if(location1[0] < location2[0]) return -1;
				else if(location1[0] == location2[0]) {
					return location1[1] - location2[1];
				}else return 1;
			}
		});
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<n; i++) {
			bw.write(location[i][0] + " " + location[i][1] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
