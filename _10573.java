package Problem_Solve;

import java.io.*;

public class _10573 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[100][11];

        for (int i = 0; i < 10; i++) dp[1][i] = 1;

        for (int i = 1; i <= 80; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k >= 0; k--) {
                    dp[i+1][k] += dp[i][j];
                }
            }
        }
        loop:
        for (int i = 0; i < t; i++) {
            char[] n = br.readLine().toCharArray();
            int len = n.length;
            char prev = '0';
            for (char j : n) {
                if (prev > j) {
                    bw.write("-1");
                    bw.newLine();
                    continue loop;
                }
                prev = j;
            }
            long res = dp[len + 1][0];
            for (int j = 0; j < len; j++) {
                int num = n[j] - '0';
                for (int k = num+1; k <= 10; k++) {
                    res -= dp[len - j][k];
                }
            }
            bw.write(String.valueOf(res-1));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
