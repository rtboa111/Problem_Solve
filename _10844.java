package Problem_Solve;

import java.io.*;
import java.util.*;

public class _10844 {

    static int N;
    static int[][] dp;
    static final int NUM = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[10][N];
        for (int i = 1; i <= 9; i++) {
            dp[i][N-1] = 1;
        }
        for (int i = N-2; i >= 0; i--) {
            dp[0][i] = dp[1][i+1];
            dp[9][i] = dp[8][i+1];
            for (int j = 1; j < 9; j++) {
                dp[j][i] = (dp[j+1][i+1] + dp[j-1][i+1]) % NUM;
            }
        }

        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[i][0]) % NUM;
        }
        System.out.println(res);
    }
}