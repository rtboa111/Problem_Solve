package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1633 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] list = new int[1001][2];
        int idx = 0;
        while (sc.hasNextInt()) {
            list[idx][0] = sc.nextInt();
            list[idx++][1] = sc.nextInt();
        }

        int[][][] dp = new int[1001][16][16];
        dp[0][1][0] = list[0][0]; dp[0][0][1] = list[0][1];
        for (int i = 1; i < idx; i++) {
            for (int j = 0; j <= 15; j++) {
                for (int k = 0; k <= 15; k++) {
                    int tmp1 = (j > 0) ? dp[i-1][j-1][k] + list[i][0] : 0;
                    int tmp2 = (k > 0) ? dp[i-1][j][k-1] + list[i][1] : 0;
                    dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(tmp1, tmp2));
                }
            }
        }
        System.out.println(dp[idx-1][15][15]);
    }
}
