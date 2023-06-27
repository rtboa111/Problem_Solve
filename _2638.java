package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _2638 {

    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = 0;
        paper[0][0] = -1;
        bfs(0,0);
        boolean check = false;
        while (!check) {
            check = true;
            ArrayList<Integer> list = new ArrayList<>(80);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (paper[i][j] == 1) {
                        int x = i;
                        int y = j;
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            x += dx[k]; y += dy[k];
                            if (x >= 0 && x < n && y >= 0 && y < m && paper[x][y] == -1) {
                                cnt++;
                            }
                            x -= dx[k]; y -= dy[k];
                        }
                        if (cnt >= 2) {
                            check = false;
                            list.add(i*m+j);
                        }
                    }
                }
            }
            for (int i : list) {
                bfs(i/m, i%m);
            }
            if (!check) {
                res++;
            }
        }
        System.out.println(res);
    }
    static void bfs(int r, int c) {
        Queue<Integer> q = new LinkedList<>();
        q.add(r*m+c);
        paper[r][c] = -1;
        while (!q.isEmpty()) {
            int cur = q.remove();
            int x = cur / m;
            int y = cur % m;

            for (int i = 0; i < 4; i++) {
                x += dx[i]; y += dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && paper[x][y] == 0) {
                    paper[x][y] = -1;
                    q.add(x*m+y);
                }
                x -= dx[i]; y -= dy[i];
            }
        }
    }
}