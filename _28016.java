package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _28016 {

    static int N, M;
    static int[] dx = new int[]{1};
    static int[] dy = new int[]{-1, 1};
    static boolean[][] board;
    static boolean[][] visit;
    static ArrayList<ArrayList<int[]>> percent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];
        board = new boolean[N][M];
        percent = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            percent.add(new ArrayList<>());
            for (int j = 0; j < M; j++) {
                percent.get(i).add(new int[N+1]);
            }
        }

        int start = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 2) {
                    start = i * M + j;
                    visit[i][j] = true;
                    percent.get(i).get(j)[0]++;
                } else if (cur == 1){
                    board[i][j] = true;
                }
            }
        }

        bfs(start);

        // N번째 요소는 2^-N 이므로 N번째 요소 2개당 N-1번째 요소 하나에 더함
        for (int i = 0; i < M; i++) {
            int[] cur = percent.get(N-1).get(i);
            for (int j = N; j >= 1; j--) {
                cur[j-1] += (cur[j] / 2);
                cur[j] = (cur[j] % 2);
            }
        }

        int[] max = new int[N+1];
        int idx = -1;

        for (int i = 0; i < M; i++) {
            int[] cur = percent.get(N-1).get(i);
            int n = 0;
            while (n <= N && max[n] == cur[n]) {
                n++;
            }
            if (n <= N && max[n] < cur[n]) {
                for (int j = 0; j <= N; j++) {
                    max[j] = cur[j];
                }
                idx = i;
            }
        }

        bw.write(idx+"");

        bw.flush();
        bw.close();
    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            int cur = q.remove();
            int x = cur / M;
            int y = cur % M;
            int[] per = percent.get(x).get(y);

            for (int i = N; i >= 1; i--) {
                per[i-1] += (per[i] / 2);
                per[i] = (per[i] % 2);
            }

            // 못을 만난 경우
            if (board[x+1][y]) {

                for (int i = 0; i < 2; i++) {

                    x += dx[0]; y += dy[i];
                    if (!(y >= M || y < 0 || board[x][y] || board[x-1][y])) {
                        if (!visit[x][y]) {
                            visit[x][y] = true;
                            // 방문 안한 위치만 q에 추가
                            if (x+1 != N) {
                                q.add(x * M + y);
                            }
                        }
                        int[] target  = percent.get(x).get(y);
                        // 확률을 반으로 나누어서 추가
                        for (int j = 0; j < N; j++) {
                            target[j+1] += per[j];
                        }
                    }
                    x -= dx[0]; y -= dy[i];
                }

            }
            // 못을 안만난 경우
            else {
                x++;
                if (!visit[x][y]) {
                    visit[x][y] = true;
                    if (x+1 != N) {
                        q.add(x * M + y);
                    }
                }
                int[] target  = percent.get(x).get(y);
                // 확률 그대로 추가
                for (int j = 0; j <= N; j++) {
                    target[j] += per[j];
                }
            }
        }

    }
}
