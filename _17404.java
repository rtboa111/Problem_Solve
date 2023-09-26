package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _17404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }
        int INF = 1<<20;
        int res = INF;
        for (int i = 0; i < 3; i++) {
            int[][] dp = new int[n][3];
            for (int j = 0; j < 3; j++) dp[0][j] = INF;

            dp[0][i] = board[0][i];
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < 3; k++) dp[j][k] = board[j][k];
                for (int k = 0; k < 3; k++) {
                    dp[j][k] += Math.min(dp[j-1][(k+1)%3], dp[j-1][(k+2)%3]);
                }
            }
            for (int j = 0; j < 3; j++) {
                if (j == i) continue;
                res = Math.min(res, dp[n-1][j]);
            }
        }
        System.out.println(res);
    }
}
