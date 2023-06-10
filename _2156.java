package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[3][N+1];
        /*
            다른 점화식 : dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + cur, dp[i-3] + dp[i-1] + cur)
         */
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(br.readLine());
            dp[0][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
            dp[1][i] = dp[0][i-1] + cur;
            dp[2][i] = dp[1][i-1] + cur;
        }
        System.out.println(Math.max(dp[0][N], Math.max(dp[1][N], dp[2][N])));
    }
}