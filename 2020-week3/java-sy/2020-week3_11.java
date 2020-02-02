package recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Stars_2447 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
		
		char[][] map = new char[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = '*';
			}
		}
		
		int number = 1;
		while(true) {
			if(number == n) break;
			for(int i=number; i<n; i+=3*number) {
				for(int j=number; j<n; j+=3*number) {
					for(int k=0; k<number; k++) {
						for(int p=0; p<number; p++) {
							map[i+p][j+k]=' ';
						}
					}
				}
			}
			number *= 3;
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(map[i]);
		}
	}
}
