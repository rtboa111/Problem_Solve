package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            weight[i] = cur;
            sum += cur;
        }

        boolean[] dp = new boolean[sum+1];
        int max = weight[0];

        for (int i = 0; i < n; i++) {
            int cur = weight[i];
            ArrayList<Integer> list = new ArrayList<>(max);
            list.add(cur);
            for (int j = max; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + cur] = true;
                    max = Math.max(max, j + cur);
                    if (j - cur > 0) {
                        list.add(j - cur);
                    }
                    if (cur - j > 0) {
                        list.add(cur - j);
                    }
                }
            }
            for (int j : list) {
                dp[j] = true;
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur <= sum && dp[cur]) {
                bw.write("Y ");
            } else {
                bw.write("N ");
            }
        }
        bw.flush();
        bw.close();
    }
}