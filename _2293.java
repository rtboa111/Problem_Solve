package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int cur = coin[i];
            for (int j = cur; j <= k; j++) {
                dp[j] += dp[j - cur];
            }
        }
        System.out.println(dp[k]);
    }
}