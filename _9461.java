package Problem_Solve;

import java.io.*;

public class _9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (1 <= N && N <= 3) {
                bw.write("1");
                bw.newLine();
                continue;
            }
            result = 0;
            padovan_sequence(N, 1, 1, 1, 3);
            bw.write(result + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static long result;

    static void padovan_sequence(int N,long b_3, long b_2, long b_1, int now) {
        if (now == N) {
            return;
        }
        result = b_3 + b_2;
        b_3 = b_2;
        b_2 = b_1;
        b_1 = result;
        padovan_sequence(N, b_3, b_2, b_1, now+1);
    }
}