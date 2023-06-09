package Problem_Solve;

import java.io.*;
import java.util.*;

public class _24416 {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 1;
        fibonacci(3);

        bw.write(dp[N]+" "+(N-2));
        bw.flush();
        bw.close();
    }
    static void fibonacci(int n) {
        if (n == N+1) {
            return;
        }
        dp[n] = dp[n-1] + dp[n-2];

        fibonacci(n+1);
    }
}