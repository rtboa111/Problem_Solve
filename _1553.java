package Problem_Solve;

import java.io.*;

public class _1553 {

    static int res;
    static boolean[][] check;
    static boolean[][] domino;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[8][7];
        check = new boolean[8][7];
        domino = new boolean[7][7];
        for (int i = 0; i < 8; i++) {
            char[] cur = br.readLine().toCharArray();
            for (int j = 0; j < 7; j++) {
                board[i][j] = cur[j] - '0';
            }
        }
        res = 0;
        dfs(0, 0, 28);
        System.out.println(res);
    }
    static void dfs(int x, int y, int num) {
        if (num == 0)  {
            res += 1;
            return;
        }


        loop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (!check[i][j]) {
                    x = i; y = j;
                    break loop;
                }
            }
        }
        check[x][y] = true;

        if (x + 1 < 8 && !domino[board[x][y]][board[x+1][y]] && !check[x+1][y]) {
            domino[board[x][y]][board[x+1][y]] = true;
            domino[board[x+1][y]][board[x][y]] = true;
            check[x+1][y] = true;
            dfs(x+1, y, num-1);
            check[x+1][y] = false;
            domino[board[x][y]][board[x+1][y]] = false;
            domino[board[x+1][y]][board[x][y]] = false;
        }

        if (y + 1 < 7 && !domino[board[x][y]][board[x][y+1]] && !check[x][y+1]) {
            domino[board[x][y]][board[x][y+1]] = true;
            domino[board[x][y+1]][board[x][y]] = true;
            check[x][y+1] = true;
            dfs(x, y+1, num-1);
            check[x][y+1] = false;
            domino[board[x][y]][board[x][y+1]] = false;
            domino[board[x][y+1]][board[x][y]] = false;
        }

        check[x][y] = false;
    }
}