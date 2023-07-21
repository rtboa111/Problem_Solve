package Problem_Solve;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2618 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());
        int[][] event = new int[W+1][2];
        StringTokenizer st;
        for (int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());
            event[i][0] = Integer.parseInt(st.nextToken());
            event[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dist = new int[W+1][W+1];
        for (int i = 1; i <= W; i++) {
            dist[0][i] = Math.abs(event[i][0] - 1) + Math.abs(event[i][1] - 1);
            dist[i][0] = Math.abs(event[i][0] - N) + Math.abs(event[i][1] - N);
            for (int j = i+1; j <= W; j++) {
                dist[i][j] = Math.abs(event[i][0] - event[j][0]) + Math.abs(event[i][1] - event[j][1]);
                dist[j][i] = dist[i][j];
            }
        }

        int[][] dp = new int[W+1][W+1];
        dp[0][1] = dist[1][0];
        dp[1][0] = dist[0][1];
        for (int i = 2; i <= W; i++) {
            dp[i][i-1] = dp[i-2][i-1] + dist[i-2][i];
            dp[i-1][i] = dp[i-1][i-2] + dist[i][i-2];
            for (int j = 0; j < i-1; j++) {
                dp[i][j] = dp[i-1][j] + dist[i-1][i];
                dp[j][i] = dp[j][i-1] + dist[i-1][i];
                dp[i][i-1] = Math.min(dp[i][i-1], dp[j][i-1] + dist[j][i]);
                dp[i-1][i] = Math.min(dp[i-1][i], dp[i-1][j] + dist[i][j]);
            }
        }

        int res = 1<<30;
        int idx = 0;
        for (int i = 0; i < W; i++) {
            int cur = Math.min(dp[W][i], dp[i][W]);
            if (res > cur) {
                res = cur;
                idx = i;
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.add((dp[W][idx] < dp[idx][W]) ? 1 : 2);
        int tmp = res;
        while (W > 1) {
            if (stack.peek() == 1) {
                int num = 0;
                for (int i = W-1; i >= 0; i--) {
                    if (i == idx) continue;
                    if (dp[i][idx] + dist[i][W] == tmp) {
                        tmp = dp[i][idx];
                        num = i;
                        break;
                    }
                }
                if (num < idx) {
                    stack.add(2);
                    W = idx;
                    idx = num;
                } else {
                    stack.add(1);
                    W = num;
                }
            } else {
                int num = 0;
                for (int i = W-1; i >= 0; i--) {
                    if (i == idx) continue;
                    if (dp[idx][i] + dist[W][i] == tmp) {
                        tmp = dp[idx][i];
                        num = i;
                        break;
                    }
                }
                if (num < idx) {
                    stack.add(1);
                    W = idx;
                    idx = num;
                } else {
                    stack.add(2);
                    W = num;
                }
            }
        }


        bw.write(String.valueOf(res));
        bw.newLine();
        while (!stack.isEmpty()) {
            bw.write(String.valueOf(stack.pop()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}