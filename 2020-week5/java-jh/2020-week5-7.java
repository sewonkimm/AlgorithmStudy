import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int index = 0;
        for (int i = 97; i <= 122; i++) {
            index = s.indexOf((char) i);
            bw.write(index + " ");
        }
        bw.flush();
    }
}