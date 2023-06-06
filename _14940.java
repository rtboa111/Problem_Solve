package Problem_Solve;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14940 {

    static int[][] map;
    static boolean[][] visit;
    static int N, M, start, len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        len = 0;
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 2) {
                    start = i*M+j;
                    cur = 0;
                }
                map[i][j] = cur;
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    map[i][j] = -1;
                }
                bw.write(map[i][j]+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            while (!q.isEmpty()) {
                q2.add(q.remove());
            }

            len++;

            while (!q2.isEmpty()) {

                int cur = q2.remove();
                int x = cur / M;
                int y = cur % M;

                x++;
                if (x < N && !visit[x][y] && map[x][y] == 1) {
                    q.add(x*M+y);
                    visit[x][y] = true;
                    map[x][y] = len;
                }

                x--; y++;
                if (y < M && !visit[x][y] && map[x][y] == 1) {
                    q.add(x*M+y);
                    visit[x][y] = true;
                    map[x][y] = len;
                }

                y--; x--;
                if (x >= 0 && !visit[x][y] && map[x][y] == 1) {
                    q.add(x*M+y);
                    visit[x][y] = true;
                    map[x][y] = len;
                }

                x++; y--;
                if (y >= 0 && !visit[x][y] && map[x][y] == 1) {
                    q.add(x*M+y);
                    visit[x][y] = true;
                    map[x][y] = len;
                }
            }
        }
    }
}