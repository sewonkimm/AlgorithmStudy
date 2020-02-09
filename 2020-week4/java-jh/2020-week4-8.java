import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String t = br.readLine();
        String p = br.readLine();
        if (t.length() < p.length()) {
            System.out.print(0);
            return;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] pi = new int[p.length()];
        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }

        j = 0;
        for (int i = 0; i < t.length(); i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (t.charAt(i) == p.charAt(j)) {
                if (j == p.length() - 1) {
                    list.add(i - p.length() + 2);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        bw.write(list.size() + "\n");
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + " ");
        }
        bw.flush();
    }
}