package Problem_Solve;

import java.io.*;
import java.util.*;

public class _16946 {

    static int N, M, cnt;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0 , -1, 0, 1};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] res = new char[N][M];
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            res[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = res[i][j] - '0' - 2;
            }
        }

        ArrayList<Integer> parents = new ArrayList<>(N*M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == -2) {
                    cnt = 0;
                    dfs(i, j, parents.size());
                    parents.add(cnt);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == -1) {
                    int cur = 1;
                    boolean[] check = new boolean[parents.size()];
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (x >= 0 && x < N && y >= 0 && y < M && board[x][y] >= 0 && !check[board[x][y]]) {
                            check[board[x][y]] = true;
                            cur += parents.get(board[x][y]);
                        }
                    }
                    res[i][j] = (char) (cur % 10 + '0');
                }
            }
        }

        for (char[] i : res) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
    static void dfs(int x, int y, int union) {
        cnt++;
        board[x][y] = union;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (xx >= 0 && xx < N && yy >= 0 && yy < M && board[xx][yy] == -2) {
                dfs(xx, yy, union);
            }
        }
    }
}