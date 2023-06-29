package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1987 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] board;
    static boolean[] check;
    static int R, C, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        check = new boolean[26];
        check[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(res);
    }
    static void dfs(int x, int y, int cnt) {
        res = Math.max(res, cnt);

        for (int j = 0; j < 4; j++) {
            x += dx[j]; y += dy[j];

            if (x < R && x >= 0 && y < C && y >= 0 && !check[board[x][y] - 'A']) {
                check[board[x][y] - 'A'] = true;
                dfs(x, y, cnt + 1);
                check[board[x][y] - 'A'] = false;
            }

            x -= dx[j]; y -= dy[j];
        }
    }
}