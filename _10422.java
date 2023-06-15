package Problem_Solve;

import java.io.*;
/*
   카탈란 수 : dp[n+1] = Σ(i = 0; i <= n)dp[i]*dp[n-i]; //(dp[0] = 1)
 */
public class _10422 {

    static final int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[2501];
        dp[0] = dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= 2500; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + (dp[j] * dp[i-j-1])) % mod;
            }
        }
        for (int i = 0; i < T; i++) {
            int L = Integer.parseInt(br.readLine());
            if (L % 2 == 1) {
                bw.write("0");
            } else {
                bw.write(dp[(L >> 1)]+"");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}