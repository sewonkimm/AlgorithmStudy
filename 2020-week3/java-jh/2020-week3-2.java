import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] results = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 || j == 0) {
                    results[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    results[i][j] = results[i - 1][j - 1] + 1;
                } else {
                    results[i][j] = Math.max(results[i - 1][j], results[i][j - 1]);
                }
            }
        }
        System.out.println(results[length1][length2]);
    }
}