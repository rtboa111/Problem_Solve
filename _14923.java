package Problem_Solve;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14923 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int Hx = Integer.parseInt(st.nextToken())-1;
        int Hy = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine());
        int Ex = Integer.parseInt(st.nextToken())-1;
        int Ey = Integer.parseInt(st.nextToken())-1;
        char[][][] board = new char[2][N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                char cur = st.nextToken().charAt(0);
                board[0][i][j] = cur;
                board[1][i][j] = cur;
            }
        }
        System.out.println(bfs(Hx, Hy, Ex, Ey, board, N, M));
    }
    static int bfs(int Hx, int Hy, int Ex, int Ey, char[][][] board, int N, int M) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{Hx, Hy, 0, 1});
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int X = cur[0], Y = cur[1];
            for (int i = 0; i < 4; i++) {
                int x = X + dx[i], y = Y + dy[i];
                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (x == Ex && y == Ey) return cur[3];
                    if (cur[2] == 0) {
                        if (board[0][x][y] == '0') {
                            q.add(new int[]{x, y, 0, cur[3] + 1});
                            board[0][x][y] = '1';
                        } else {
                            q.add(new int[]{x, y, 1, cur[3] + 1});
                        }
                        continue;
                    }
                    if (board[1][x][y] == '0') {
                        q.add(new int[]{x, y, 1, cur[3] + 1});
                        board[1][x][y] = '1';
                    }
                }
            }
        }
        return -1;
    }
}