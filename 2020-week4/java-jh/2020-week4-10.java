import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(" ");
        PriorityQueue<String[]> pq = new PriorityQueue<String[]>(new Comparator<String[]>() {
            @Override
            public int compare(String[] strs1, String[] strs2) {
                int n = strs1.length < strs2.length ? strs1.length : strs2.length;
                for (int i = 0; i < n; i++) {
                    int temp = strs1[i].compareTo(strs2[i]);
                    if (temp == 0) {
                        continue;
                    } else {
                        return temp;
                    }
                }
                return strs1.length == n ? -1 : 1;
            }
        });
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] info = new String[k];
            for (int j = 0; j < k; j++) {
                info[j] = st.nextToken();
            }
            pq.offer(info);
        }
        int index = 0;
        String[] priorInfo = new String[0];
        while (!pq.isEmpty()) {
            String[] curInfo = pq.poll();
            int length = priorInfo.length < curInfo.length ? priorInfo.length : curInfo.length;
            for (int i = 0; i < length; i++) {
                if (!priorInfo[i].equals(curInfo[i])) {
                    index = i;
                    break;
                }
                if (i == length - 1) {
                    index = 0;
                }
            }
            for (int i = index; i < curInfo.length; i++) {
                for (int j = 0; j < i; j++) {
                    bw.write("--");
                }
                bw.write(curInfo[i] + "\n");
            }
            priorInfo = new String[curInfo.length];
            for (int i = 0; i < curInfo.length; i++) {
                priorInfo[i] = curInfo[i];
            }
        }
        bw.flush();
    }
}