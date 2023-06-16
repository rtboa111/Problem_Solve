package Problem_Solve;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class _12852 {

    static int[] dp;
    static int x;
    static Deque<Integer> d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        x = Integer.parseInt(br.readLine());
        d = new LinkedList<>();
        dp = new int[x+1];
        dp[0] = Integer.MAX_VALUE;
        dp[1] = 0;
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        dp(x);

        bw.write(dp[x]+"");
        bw.newLine();
        bw.write(x+" ");
        for (int i : d) {
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }

    static void dp(int cur) {
        if (cur == 1) {
            return;
        }

        int num = dp[cur-1] + 1;
        d.add(cur-1);
        if (cur % 2 == 0 && num > dp[cur/2] + 1) {
            d.removeLast();
            num = dp[cur/2] + 1;
            d.add(cur/2);
        }
        if (cur % 3 == 0 && num > dp[cur/3] + 1) {
            d.removeLast();
            num = dp[cur/3] + 1;
            d.add(cur/3);
        }

        dp(d.peekLast());
    }
}