package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _2206 {

    static char[][] map;
    static boolean[][][] visit;
    static int N, M, cnt;
    static boolean goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[2][N][M];   // 벽을 부수지 않은 상태와 부순상태에서의 방문기록
        goal = false;
        cnt = 1;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visit[1][0][0] = true;

        bfs();

        if (!goal) {
            cnt = -1;
        }

        System.out.println(cnt);
    }
    static void bfs() {
        java.util.Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q.add(new int[]{0, 1});     // {좌표, 부수기 가능}

        while (!q.isEmpty()) {

            while (!q.isEmpty()) {
                int[] cur = q.remove();
                if (cur[0] == (N*M-1)) {
                    goal = true;
                    return;
                }
                q2.add(cur);
            }

            cnt++;

            while (!q2.isEmpty()) {
                int[] cur = q2.remove();
                int x = cur[0] / M;
                int y = cur[0] % M;

                x++;
                if (x < N && !visit[cur[1]][x][y]) {
                    if (map[x][y] == '1') {
                        if (cur[1] == 1) {
                            q.add(new int[]{x*M+y, 0});
                        }
                    } else {
                        q.add(new int[]{x*M+y, cur[1]});
                    }
                    visit[cur[1]][x][y] = true;
                }

                x--; y++;
                if (y < M && !visit[cur[1]][x][y]) {
                    if (map[x][y] == '1') {
                        if (cur[1] == 1) {
                            q.add(new int[]{x*M+y, 0});
                        }
                    } else {
                        q.add(new int[]{x*M+y, cur[1]});
                    }
                    visit[cur[1]][x][y] = true;
                }

                y--; x--;
                if (x >= 0 && !visit[cur[1]][x][y]) {
                    if (map[x][y] == '1') {
                        if (cur[1] == 1) {
                            q.add(new int[]{x*M+y, 0});
                        }
                    } else {
                        q.add(new int[]{x*M+y, cur[1]});
                    }
                    visit[cur[1]][x][y] = true;
                }

                x++; y--;
                if (y >= 0 && !visit[cur[1]][x][y]) {
                    if (map[x][y] == '1') {
                        if (cur[1] == 1) {
                            q.add(new int[]{x*M+y, 0});
                        }
                    } else {
                        q.add(new int[]{x*M+y, cur[1]});
                    }
                    visit[cur[1]][x][y] = true;
                }
            }
        }
    }
}