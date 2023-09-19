package Problem_Solve;

import java.io.*;

public class _14939 {

    static int res;
    static int[] board;
    static int[] dx = {1, 0, -1, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[10];
        for (int i = 0; i < 10; i++) {
            char[] cur = br.readLine().toCharArray();
            int num = 0;
            for (int j = 9; j >= 0; j--) {
                if (cur[j] == 'O') num |= 1 << j;
            }
            board[i] = num;
        }
        res = 101;
        dfs(0, 0, 0);
        System.out.println(res);
    }
    static void dfs(int r, int c, int cnt) {
        if (c == 10) {
            r++; c = 0;
            if (r == 10) {
                res = (board[9] == 0) ? Math.min(res, cnt) : res;
                return;
            }
        }
        if (r == 0) {
            board[0] ^= 1<<c;
            board[1] ^= 1<<c;
            if (c > 0) board[0] ^= 1<<(c-1);
            if (c < 9) board[0] ^= 1<<(c+1);
            dfs(0, c+1, cnt+1);
            board[1] ^= 1<<c;
            if (c > 0) board[0] ^= 1<<(c-1);
            if (c < 9) board[0] ^= 1<<(c+1);
            board[0] ^= 1<<c;
            dfs(0, c+1, cnt);
            return;
        }

        if ((board[r-1] | 1<<c) > board[r-1]) {
            dfs(r, c+1, cnt);
            return;
        }
        for (int i = 0; i < 5; i++) {
            int x = r + dx[i], y = c + dy[i];
            if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                board[x] ^= 1<<y;
            }
        }
        dfs(r, c+1, cnt+1);
        for (int i = 0; i < 5; i++) {
            int x = r + dx[i], y = c + dy[i];
            if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                board[x] ^= 1<<y;
            }
        }
    }
}
