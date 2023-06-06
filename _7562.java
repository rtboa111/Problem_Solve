package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _7562 {

    static int l, end, cnt;
    static int[] dx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) * l + Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end = Integer.parseInt(st.nextToken()) * l + Integer.parseInt(st.nextToken());
            visit = new boolean[l*l];
            visit[start] = true;
            cnt = 0;

            bfs(start);

            bw.write(cnt+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static boolean[] visit;
    static void bfs(int start) {
        java.util.Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            while (!q.isEmpty()) {
                int cur = q.remove();
                if (cur == end) {
                    return;
                }
                q2.add(cur);
            }

            cnt++;

            while (!q2.isEmpty()) {
                int cur = q2.remove();
                int x = cur / l;
                int y = cur % l;

                for (int i = 0; i < 8; i++) {
                    x += dx[i];
                    y += dy[i];
                    if (x < l && y < l && x >= 0 && y >= 0 && !visit[x*l+y]) {
                        visit[x*l+y] = true;
                        q.add(x*l+y);
                    }
                    x -= dx[i];
                    y -= dy[i];
                }
            }
        }
    }
}