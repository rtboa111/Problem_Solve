package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2294 {

    static int n, k;
    static Integer[][] dp;
    static int[] coin;
    static final int max = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new Integer[n][k+1];
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int res = dp(0, k);

        System.out.println((res == max) ? -1 : res);
    }
    static int dp(int cur, int tar) {
        if (cur == n) {
            if (tar == 0) {
                return 0;
            } else {
                return max;
            }
        }

        if (dp[cur][tar] != null) {
            return dp[cur][tar];
        }

        int res = dp(cur + 1, tar);

        if (tar >= coin[cur]) {
            res = Math.min(res, dp(cur, tar - coin[cur]) + 1);
        }
        dp[cur][tar] = res;
        return res;
    }
}