import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if (str1.length() > str2.length()) {
                    return 1;
                } else if (str1.length() == str2.length()) {
                    return str1.compareTo(str2);
                } else {
                    return -1;
                }
            }
        });
        bw.write(strs[0] + "\n");
        for (int i = 1; i < n; i++) {
            if (!strs[i].equals(strs[i - 1]))
                bw.write(strs[i] + "\n");
        }
        bw.flush();
    }
}