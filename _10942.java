package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) dp[i][i] = 1;
        for (int i = 1; i < n; i++) dp[i][i+1] = (arr[i] == arr[i+1]) ? 1 : 0;

        for (int i = n-1; i >= 1; i--) {
            for (int j = i+2; j <= n; j++) {
                if (arr[i] == arr[j] && dp[i+1][j-1] == 1) dp[i][j] = 1;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(dp[s][e]));
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}