package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Stack;

public class _2655 {
    static class block {
        int num, area, height, weight;
        public block(int num, int area, int height, int weight) {
            this.num = num;
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        ArrayList<block> blocks = new ArrayList<>(n+1);
        blocks.add(new block(0, 0, 0, 0));
        java.util.Stack<block> towel = new Stack<>();
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            blocks.add(new block(i, a, h, w));
        }
        blocks.sort((o1, o2) -> o1.area - o2.area);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (blocks.get(i).weight > blocks.get(j).weight) {
                    dp[i] = Math.max(dp[i], dp[j] + blocks.get(i).height);
                }
            }
            max = Math.max(max, dp[i]);
        }
        while (n > 0) {
            if (max == dp[n]) {
                towel.add(blocks.get(n));
                max -= blocks.get(n).height;
            }
            n--;
        }
        bw.write(towel.size()+"");
        while (!towel.isEmpty()) {
            bw.newLine();
            bw.write(towel.pop().num+"");
        }
        bw.flush();
        bw.close();
    }
}