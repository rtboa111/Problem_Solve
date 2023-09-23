package Problem_Solve;

import java.io.*;
import java.util.*;

public class _12100 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] sx, sy;
    static int[][] board;
    static int n, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sx = new int[]{n-1, 0, 0, 0};
        sy = new int[]{0, 0, 0, n-1};
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = 0;
        backtracking(0);
        System.out.println(res);
    }
    static void MAX() { for (int i = 0; i < n*n; i++) res = Math.max(res, board[i/n][i%n]); }
    static void backtracking(int cnt) {
        if (cnt == 5) {
            MAX();
            return;
        }

        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) tmp[i] = board[i].clone();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) board[j] = tmp[j].clone();
            execute(i);
            backtracking(cnt+1);
        }
    }
    static void execute(int dir) {
        boolean[] check = new boolean[n*n];
        if (dir % 2 == 0) {
            for (int y = 0; y < n; y++) {
                for (int i = 0; i < n; i++) {
                    int x = sx[dir] - dx[dir]*i;
                    if (board[x][y] == 0) continue;
                    for (int k = 1; k <= i+1; k++) {
                        int xx = x + dx[dir]*k;
                        if (!obs(xx, y) || (board[xx][y] != 0 && board[xx][y] != board[x][y]) || check[xx*n+y]) {
                            if (k == 1) break;
                            xx = x + dx[dir]*(k-1);
                            board[xx][y] = board[x][y];
                            board[x][y] = 0;
                            break;
                        }
                        if (board[xx][y] == 0) continue;
                        if (board[xx][y] == board[x][y]) {
                            board[x][y] = 0;
                            board[xx][y] <<= 1;
                            check[xx*n+y] = true;
                            break;
                        }
                    }
                }
            }
        } else {
            for (int x = 0; x < n; x++) {
                for (int i = 0; i < n; i++) {
                    int y = sy[dir] - dy[dir]*i;
                    if (board[x][y] == 0) continue;
                    for (int k = 1; k <= i+1; k++) {
                        int yy = y + dy[dir]*k;
                        if (!obs(x, yy) || (board[x][yy] != 0 && board[x][yy] != board[x][y]) || check[x*n+yy]) {
                            if (k == 1) break;
                            yy = y + dy[dir]*(k-1);
                            board[x][yy] = board[x][y];
                            board[x][y] = 0;
                            break;
                        }
                        if (board[x][yy] == 0) continue;
                        if (board[x][yy] == board[x][y]) {
                            board[x][y] = 0;
                            board[x][yy] <<= 1;
                            check[x*n+yy] = true;
                            break;
                        }
                    }
                }
            }
        }

    }
    static boolean obs(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}
