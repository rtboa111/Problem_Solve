package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _1520 {

    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new Integer[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0));;
    }
    static int dfs(int cordi) {
        if (cordi == N * M - 1) {
            return 1;
        }

        int x = cordi / M;
        int y = cordi % M;

        if (dp[x][y] == null) {
            dp[x][y] = 0;
        } else {
            return dp[x][y];
        }

        int curX = x;
        int curY = y;

        for (int i = 0; i < 4; i++) {
            curX += dx[i]; curY += dy[i];

            if (curX < 0 || curY < 0 || curX >= N || curY >= M || map[x][y] <= map[curX][curY]) {
                curX -= dx[i]; curY -= dy[i];
                continue;
            }

            dp[x][y] += dfs(curX * M + curY);

            curX -= dx[i]; curY -= dy[i];
        }

        return dp[x][y];
    }
}