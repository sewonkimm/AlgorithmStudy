import java.io.*;
import java.util.*;

class Main {

    static long fac(long curVal, long targetVal) {
        if (curVal == 1 || curVal == targetVal)
            return curVal == 1 ? 1 : targetVal;
        return curVal * fac(curVal - 1, targetVal);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        System.out.print(fac(n, n - m + 1) / fac(m, 1));
    }
}