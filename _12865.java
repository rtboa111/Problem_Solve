package Problem_Solve;

import java.io.*;
import java.util.*;

public class _12865 {

    static int[] dp;
    static int N, K;
    static int[][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        info = new int[N][2];
        dp = new int[K+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            info[i][0] = w;
            info[i][1] = v;
        }

        knapsack();

        int res = 0;
        for (int i = 0; i <= K; i++) {
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }
    static void knapsack() {

        for (int i = 0; i < N; i++) {
            for (int j = K; j >= 1; j--) {
                if (info[i][0] <= j) {
                    dp[j] = Math.max(dp[j], info[i][1]+dp[j - info[i][0]]);
                }
            }
        }
    }
}