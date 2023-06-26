package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _17070 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = true;
                }
            }
        }

        int[][][] dp = new int[3][N][N];
        dp[1][0][1] = 1;
        for (int i = 2; i < N; i++) {
            if (map[0][i]) {
                continue;
            }
            dp[1][0][i] = dp[1][0][i-1];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                boolean[] check = new boolean[4];
                int cnt = 0;
                for (int x = i-1; x <= i; x++) {
                    for (int y = j-1; y <= j; y++) {
                        if (map[x][y]) {
                            check[cnt] = true;
                        }
                        cnt++;
                    }
                }
                if (check[3]) {
                    continue;
                }
                if (!check[2]) {
                    dp[1][i][j] += dp[1][i][j-1];
                    cnt++;
                    if (!check[0]) {
                        dp[1][i][j] += dp[0][i][j-1];
                        cnt++;
                    }
                }
                if (!check[1]) {
                    dp[2][i][j] += dp[2][i-1][j];
                    cnt++;
                    if (!check[0]) {
                        dp[2][i][j] += dp[0][i-1][j];
                    }
                }
                if (cnt == 7) {
                    dp[0][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
                }
            }
        }
        int res = dp[0][N-1][N-1] + dp[1][N-1][N-1] + dp[2][N-1][N-1];
        System.out.println(res);
    }
}