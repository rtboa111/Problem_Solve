package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17472 {

    static int[][] board;
    static int[] parents;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    dfs(i, j, num++);
                }
            }
        }

        parents = new int[num];
        int[][] g = new int[num][num];
        for (int i = 0; i < num; i++) {
            Arrays.fill(g[i], 100);
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0) {
                    int s = board[i][j];
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k], cnt = 0;
                        while (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 0) {
                            x += dx[k]; y += dy[k];
                            cnt++;
                        }
                        if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] != 0 && cnt > 1) {
                            int e = board[x][y];
                            g[s][e] = Math.min(g[s][e], cnt);
                        }
                    }
                }
            }
        }
        ArrayList<int[]> graph = new ArrayList<>(100);
        for (int i = 2; i < num; i++) {
            for (int j = 2; j < num; j++) {
                if (g[i][j] < 100) graph.add(new int[]{g[i][j], i, j});
            }
        }
        graph.sort((o1, o2) -> o1[0] - o2[0]);

        int res = 0;
        int cnt = 0;
        for (int[] i : graph) {
            if (union(i[1], i[2])) {
                res += i[0];
                cnt++;
            }
        }
        System.out.println((cnt < num-3) ? -1 : res);
    }
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return false;
        parents[B] = A;
        return true;
    }
    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    static void dfs(int x, int y, int num) {

        board[x][y] = num;
        for (int i = 0; i < 4; i++) {
            x += dx[i]; y += dy[i];
            if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 1) {
                dfs(x, y, num);
            }
            x -= dx[i]; y -= dy[i];
        }
    }
}