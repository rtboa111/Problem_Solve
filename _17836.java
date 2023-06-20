package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _17836 {

    static int N, M, T, gram, swordTime;
    static int[][] castle;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        castle = new int[N][M];
        gram = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 2) {
                    cur = 0;
                    gram = i * M + j;
                }
                castle[i][j] = cur;
            }
        }
        swordTime = T+1;

        if (gram == 0) {
            bfs2(0, 0);
            System.out.println(swordTime);
        } else {
            int res = Math.min(bfs(), swordTime);
            System.out.println((res == T+1) ? "Fail" : res);
        }
    }
    static int bfs() {
        java.util.Queue<Integer> q = new LinkedList<>();
        java.util.Queue<Integer> q2 = new LinkedList<>();
        q.add(0);
        int time = 0;
        boolean[] visit = new boolean[N*M];
        visit[0] = true;
        while (!q.isEmpty()) {

            while (!q.isEmpty()) {
                q2.add(q.remove());
            }
            time++;

            while (!q2.isEmpty()) {
                int cur = q2.remove();
                int x = cur / M, y = cur % M;

                for (int i = 0; i < 4; i++) {
                    x += dx[i]; y += dy[i];

                    if (x >= 0 && y >= 0 && x < N && y < M && !visit[x*M+y] && castle[x][y] == 0) {
                        if (x*M+y == N*M-1) return (time <= T) ? time : T+1;
                        visit[x*M+y] = true;

                        if (x*M+y == gram) {
                            bfs2(x*M+y, time);
                        }

                        q.add(x*M+y);
                    }

                    x -= dx[i]; y -= dy[i];
                }
            }
        }

        return T+1;
    }
    static void bfs2(int s, int time) {
        java.util.Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(s);
        boolean[] visit = new boolean[N*M];
        visit[s] = true;
        while (!q.isEmpty()) {

            while (!q.isEmpty()) {
                q2.add(q.remove());
            }
            time++;

            while (!q2.isEmpty()) {
                int cur = q2.remove();
                int x = cur / M, y = cur % M;

                for (int i = 0; i < 4; i++) {
                    x += dx[i]; y += dy[i];

                    if (x >= 0 && y >= 0 && x < N && y < M && !visit[x*M+y]) {
                        if (x*M+y == N*M-1) {
                            swordTime = (time <= T) ? time : T+1;
                            return;
                        }

                        visit[x*M+y] = true;

                        q.add(x*M+y);
                    }

                    x -= dx[i]; y -= dy[i];
                }
            }
        }
    }
}