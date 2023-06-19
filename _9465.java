package Problem_Solve;

import java.io.*;
import java.util.*;

public class _9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[][] dp = new int[2][n];
            for (int j = 0; j < n; j++) {
                dp[0][j] = Integer.parseInt(st.nextToken());
                dp[1][j] = Integer.parseInt(st2.nextToken());
            }
            for (int j = 1; j < n; j++) {
                if (j > 1) {
                    dp[0][j] += Math.max(dp[1][j - 1], Math.max(dp[0][j - 2], dp[1][j - 2]));
                    dp[1][j] += Math.max(dp[0][j - 1], Math.max(dp[0][j - 2], dp[1][j - 2]));
                } else {
                    dp[0][j] += dp[1][j - 1];
                    dp[1][j] += dp[0][j - 1];
                }
            }

            bw.write(Math.max(dp[0][n-1], dp[1][n-1])+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}