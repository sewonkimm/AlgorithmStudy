import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int temp;
        String strTemp;
        for (int i = 0; i < n; i++) {
            temp = i;
            strTemp = Integer.toString(i);
            for (int j = 0; j < strTemp.length(); j++) {
                temp += ((int) strTemp.charAt(j) - 48);
            }
            if (temp == n) {
                System.out.print(i);
                return;
            }
        }
        System.out.print(0);
    }
}