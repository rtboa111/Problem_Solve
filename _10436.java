package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _10436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(st.nextToken() + " ");
            st = new StringTokenizer(st.nextToken(), "/");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                bw.write("1/" + (p + 1L));
            } else if (p > q) {
                long a = p;
                long b = q;
                int cnt = p / q;
                a %= b;
                b -= a;
                a = a + b;

                b += a * cnt;
                long n = gcd(a, b);
                bw.write((a / n) + "/" + (b / n));
            } else {
                long a = q;
                long b = q - p;
                long n = gcd(a, b);
                bw.write((a / n) + "/" + (b / n));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}