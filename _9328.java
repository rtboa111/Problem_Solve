package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Deque;
import java.util.Queue;

public class _9328 {

    static int h, w, res, keys;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] board;
    static Deque<int[]> starting;
    static ArrayList<Queue<int[]>> sPointCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            starting = new ArrayDeque<>(w*2+h*2);
            sPointCheck = new ArrayList<>(26);
            for (int i = 0; i < 26; i++) sPointCheck.add(new LinkedList<>());
            board = new char[h][w];
            keys = 0;
            for (int i = 0; i < h; i++) {
                board[i] = br.readLine().toCharArray();
                int num = w-1;
                if (i == 0 || i == h-1) {
                    num = 1;
                }
                for (int j = 0; j < w; j+=num) {
                    if (board[i][j] >= 'a') {
                        keys |= 1 << (board[i][j] - 'a');
                        board[i][j] = '.';
                    }
                }
            }
            char[] Keys = br.readLine().toCharArray();
            if (Keys[0] != '0') {
                for (char i : Keys) {
                    keys |= 1 << (i - 'a');
                }
            }

            res = 0;
            for (int i = 0; i < h; i++) {
                int num = w-1;
                if (i == 0 || i == h-1) {
                    num = 1;
                }
                for (int j = 0; j < w; j+=num) {
                    if (board[i][j] == '*') continue;
                    if (board[i][j] >= 'A') {
                        if ((keys | (1 << (board[i][j] - 'A'))) != keys) {
                            sPointCheck.get(board[i][j] - 'A').add(new int[]{i, j});
                            continue;
                        }
                    }
                    res += (board[i][j] == '$') ? 1 : 0;
                    starting.add(new int[]{i, j});
                    board[i][j] = '.';
                }
            }
            dfs();
            sb.append(res).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void dfs() {
        boolean[][] check = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
        for (int[] i : starting) {
            check[i[0]][i[1]] = true;
            q.add(i);
        }

        loop:
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            for (int i = 0; i < 4; i++) {
                int xx = cur[0] + dx[i], yy = cur[1] + dy[i];
                if (xx >= 0 && xx < h && yy >= 0 && yy < w && !check[xx][yy]) {
                    if (board[xx][yy] == '*') continue;
                    if (board[xx][yy] >= 'A' && board[xx][yy] <= 'Z' && (keys | (1 << (board[xx][yy] - 'A'))) != keys) continue;
                    if (board[xx][yy] >= 'a' && (keys | (1 << (board[xx][yy] - 'a'))) != keys) {
                        Queue<int[]> tmp = sPointCheck.get((board[xx][yy] - 'a'));
                        while (!tmp.isEmpty()) starting.addFirst(tmp.remove());
                        starting.addFirst(new int[]{xx, yy});
                        keys |= (1 << (board[xx][yy] - 'a'));
                        q.add(new int[]{0, 0});
                        board[xx][yy] = '.';

                        break loop;
                    }
                    res += (board[xx][yy] == '$') ? 1 : 0;
                    board[xx][yy] = '.';
                    check[xx][yy] = true;
                    q.add(new int[]{xx, yy});
                }
            }
        }
        if (!q.isEmpty()) dfs();
    }
}