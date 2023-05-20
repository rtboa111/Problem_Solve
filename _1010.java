package Problem_Solve;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N==M) {
                bw.write("1");
            } else {
                bw.write(bridge(N, M));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static String bridge(int N, int M) {
        BigInteger t = new BigInteger("1");
        for (int i = M; i > M - N; i--) {
            t = t.multiply(BigInteger.valueOf(i));
        }
        for (int i = N; i >= 2; i--) {
            t = t.divide(BigInteger.valueOf(i));
        }
        return t.toString();
    }
}