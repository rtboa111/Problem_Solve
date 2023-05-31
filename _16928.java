package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _16928 {

    // bfs 는 최초 방문이 최소 횟수가 보장됨
    static boolean[] visit = new boolean[101];
    static int[] info = new int[101];
    static java.util.Queue<Integer> q = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        info = new int[101];
        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            info[x] = y;
        }
        visit[1] = true;
        for (int i = 2; i <= 7; i++) {
            if (info[i] != 0) {
                visit[info[i]] = true;
                q.add(info[i]);
            } else {
                visit[i] = true;
                q.add(i);
            }
        }
        int count = 1;
        while (!q.isEmpty()) {
            q2 = new LinkedList<>();
            while (!q.isEmpty()) {
                q2.add(q.remove());
            }
            count++;
            while (!q2.isEmpty()) {
                bfs();
            }
        }
        System.out.println(count);
    }
    static void bfs() {
        int cur = q2.remove();
        int tmp;
        for (int i = 1; i <= 6; i++) {
            tmp = (cur + i);

            if (tmp > 100 || visit[tmp]) continue;

            if (info[tmp] != 0) {
                tmp = info[tmp];
            }

            if (visit[tmp]) continue;

            visit[tmp] = true;
            if (tmp == 100) {
                q.clear();
                q2.clear();
                return;
            }
            q.add(tmp);
        }
    }
}