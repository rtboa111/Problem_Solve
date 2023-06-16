package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _28017 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int cur = Integer.MAX_VALUE;
                for (int k = 1; k <= M; k++) {
                    if (j != k) {
                        cur = Math.min(cur, dp[i-1][k]);
                    }
                }
                dp[i][j] += cur;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= M; i++) {
            res = Math.min(res, dp[N][i]);
        }
        System.out.println(res);
    }
}