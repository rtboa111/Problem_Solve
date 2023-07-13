package Problem_Solve;

import java.io.*;

public class _2482 {
    static final int MOD = 1000000003;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1; dp[i][1] = i;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-2][j-1];
                dp[i][j] %= MOD;
            }
        }

        // 마지막 선택은 첫번째꺼 선택에 영향이 있으므로 마지막 전것 까지의 선택으로 함
        System.out.println((dp[N-1][K] + dp[N-3][K-1]) % MOD);
    }
}