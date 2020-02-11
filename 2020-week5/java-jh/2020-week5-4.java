import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = 1000 - Integer.parseInt(br.readLine());
        int[] changes = { 500, 100, 50, 10, 5, 1 };
        int answer = 0;
        for (int i = 0; i < changes.length; i++) {
            if (change / changes[i] > 0) {
                answer += (change / changes[i]);
                change %= changes[i];
            }
        }
        System.out.print(answer);
    }
}