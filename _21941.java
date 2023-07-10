package Problem_Solve;

import java.io.*;
import java.util.*;

public class _21941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int len = S.length();
        int M = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>(M * 2);
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = i-1; j >= 0; j--) {
                dp[i] = Math.max(dp[i], map.getOrDefault(S.substring(j, i), 0) + dp[j]);
            }
        }

        System.out.println(dp[len]);
    }
}