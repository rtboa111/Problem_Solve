package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _1311 {

    static int n;
    static final int INF = 1<<28;
    static Integer[] dp;
    static int[][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[1<<n];
        info = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dp(0, 0));
    }
    static int dp(int check, int r) {
        if (r == n) return 0;

        if (dp[check] != null) return dp[check];

        dp[check] = INF;

        for (int i = 0; i < n; i++) {
            if (((check >> i) & 1) != 0) continue;
            dp[check] = Math.min(dp[check], info[r][i] + dp(check | (1<<i), r+1));
        }
        return dp[check];
    }
}
