package Problem_Solve;

import java.io.*;
import java.util.*;

public class _11066 {

    static int N;
    static int[] filePrefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            filePrefixSum = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                filePrefixSum[j] = filePrefixSum[j-1] + Integer.parseInt(st.nextToken());
            }

            bw.write(dp()+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int dp() {
        // dp[i][j] 는 i~j 장까지 묶음의 최소값
        int[][] dp = new int[N+1][N+1];

        // 묶음 사이즈
        for (int i = 1; i <= N; i++) {
            /*
               묶음 시작 위치 : j
               묶음 나누는 지점 : div
               묶음 끝나는 위치 : end
             */
            for (int j = 1; j + i <= N; j++) {
                int end = j + i;
                dp[j][end] = Integer.MAX_VALUE;
                for (int div = j; div < end; div++) {
                    dp[j][end] = Math.min(dp[j][end], dp[j][div] + dp[div+1][end] + filePrefixSum[end] - filePrefixSum[j-1]);
                }
            }
        }
        return dp[1][N];
    }
}