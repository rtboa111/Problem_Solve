package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _11724 {
    static Queue<Integer> q = new LinkedList<>();
    static boolean[][] linked;
    static boolean[] check_add, check_visit;
    static int N, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        linked = new boolean[N][N];     // 정점간의 연결성
        check_add = new boolean[N];     // queue 에 추가한 정점 목록
        check_visit = new boolean[N];   // 방문한 정점 목록
        count = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            linked[from][to] = true;
            linked[to][from] = true;
        }

        q.add(0);
        check_add[0] = true;
        boolean end = false;
        while (!end) {
            while (!q.isEmpty()) {  // 연결되어있는 정점들 모두 탐색
                int x = q.remove();
                if (!check_visit[x]) {
                    visit(x);
                }
            }
            count++;
            for (int i = 0; i < N; i++) {
                if (!check_visit[i]) {  // 탐색하지 않은 정점이 있는 경우 재탐색
                    q.add(i);
                    check_add[i] = true;
                    end = false;
                    break;
                }
                end = true;
            }
        }

        System.out.println(count);
    }

    static void visit(int x) {  // bfs 를 통한 그래프 탐색
        check_visit[x] = true;
        for (int i = 0; i < N; i++) {
            if (linked[x][i] && !check_add[i]) {
                check_add[i] = true;
                q.add(i);
            }
        }
    }
}
