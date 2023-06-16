package Problem_Solve;

import java.io.*;

public class _26437 {

    static final int max = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[max];
        for (int i = 1; i < max; i++) {
            dp[i] = i;
        }
        for (int i = 2; i < max ; i++) {
            dp[i] = Math.min(dp[i], dp[i-1]+1);
            for (int j = 2; i * j < max; j++) {
                dp[i*j] = Math.min(dp[i*j], dp[i] + 4 + (2 * (j-1)));
            }
        }
        for (int t = 1; t <= T; t++) {
            int L = Integer.parseInt(br.readLine());
            bw.write("Case #" + t + ": " + dp[L]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}