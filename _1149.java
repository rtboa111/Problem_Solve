package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1149 {

    static int[][] dp, cost;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        int res = Integer.MAX_VALUE;

        minCost(-1, 0, 0);

        for (int i = 0; i < 3; i++) {
            res = Math.min(res, dp[N-1][3]);
        }
        System.out.println(res);
    }

    static void minCost(int color, int idx, int costSum) {
        if (idx == N) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (color != i && (dp[idx][i] == 0 || dp[idx][i] > costSum+cost[idx][i])) {
                dp[idx][i] = costSum+cost[idx][i];
                minCost(i, idx+1, costSum+cost[idx][i]);
            }
        }
    }
}