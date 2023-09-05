package Problem_Solve;

import java.io.*;

public class _1562 {

    static int N;
    static final int MOD = (int) 1e9;
    static Long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Long[N][10][1 << 10];
        long res = 0;
        for (int i = 1; i <= 9; i++) {
            res += dfs(i, 1 << i, 1);
            res %= MOD;
        }
        System.out.println(res);
    }
    static long dfs(int prev, int check, int num) {
        if (num == N) {
            return (check == (1 << 10)-1) ? 1 : 0;
        }

        if (dp[num][prev][check] != null) return dp[num][prev][check];

        long ans = 0;

        if (prev == 0) {
            ans += dfs(1, check | 1 << 1, num+1);
        } else if (prev == 9) {
            ans += dfs(8, check | 1 << 8, num+1);
        } else {
            ans += dfs(prev+1, check | 1 << prev+1, num+1);
            ans += dfs(prev-1, check | 1 << prev-1, num+1);
        }

        return dp[num][prev][check] = ans % MOD;
    }
}