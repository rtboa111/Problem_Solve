package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2229 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int min = Integer.MAX_VALUE, max = 0;
            for (int j = i; j >= 1; j--) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], dp[j-1] + max - min);
            }
        }
        System.out.println(dp[N]);
    }
}