package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _25633 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = arr[i];
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                if (dp[i-1][j-1] >= arr[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + arr[i]);
                }
            }
        }
        for (int i = n; i >= 1; i--) {
            if (dp[n][i] != 0) {
                System.out.println(i);
                return;
            }
        }
    }
}