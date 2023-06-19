package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] app = new int[N][2];
        int costSum = 0;
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            app[i][0] = Integer.parseInt(st.nextToken());
            app[i][1] = Integer.parseInt(st2.nextToken());
            costSum += app[i][1];
        }

        int[] dp = new int[costSum+1];
        for (int i = 0; i < N; i++) {
            int cost = app[i][1];
            int memory = app[i][0];

            for (int j = costSum; j >= cost; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost] + memory);
            }
        }

        for (int i = 0; i <= costSum; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}