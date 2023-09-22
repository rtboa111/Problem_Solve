package Problem_Solve;

import java.io.*;
import java.util.*;

public class _19236 {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[][] board;
    static int[] dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[4][4];
        dir = new int[18];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken())-1;
                dir[a] = b;
                board[i][j] = a;
            }
        }
        res = 0;
        int s = board[0][0];
        dir[17] = dir[s];
        board[0][0] = 17;
        dfs(s);

        System.out.println(res);
    }
    static int res;
    static void dfs(int cnt) {
        res = Math.max(res, cnt);
        int x = -1, y = -1;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if (board[i][j] != 17) continue;
                x = i; y = j;
                break;
            }
        }
        for (int i = 1; i <= 16; i++) {
            move(i);
        }
        int[][] tmp = new int[4][4];
        int[] tmp2 = dir.clone();
        for (int i = 0; i < 4; i++) tmp[i] = board[i].clone();

        for(int i = 1; i < 4; i++) {
            int xx = x + dx[tmp2[17]]*i, yy = y + dy[tmp2[17]]*i;
            if (!check(xx, yy, tmp) || tmp[xx][yy] == 0) continue;
            int num = tmp[xx][yy];
            int num2 = tmp2[17];
            tmp[x][y] = 0;
            tmp[xx][yy] = 17;
            tmp2[17] = tmp2[num];

            dir = tmp2.clone();
            for (int j = 0; j < 4; j++) board[j] = tmp[j].clone();
            dfs(cnt + num);

            tmp[x][y] = 17;
            tmp[xx][yy] = num;
            tmp2[17] = num2;
        }
    }

    static boolean check(int x, int y, int[][] board) {
        return (x >= 0 && x < 4 && y >= 0 && y < 4 && board[x][y] != 17);
    }
    static void move(int num) {
        int x = -1, y = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != num) continue;
                x = i; y = j;
                break;
            }
        }
        if (x == -1) return;
        int n = 8;
        while (n-- > 0) {
            int xx = x + dx[dir[num]], yy = y + dy[dir[num]];
            if (!check(xx, yy, board)) {
                dir[num] = (dir[num] + 9) % 8;
                continue;
            }
            int tmp = board[xx][yy];
            board[xx][yy] = num;
            board[x][y] = tmp;
            break;
        }
    }
}