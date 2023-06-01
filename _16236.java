package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _16236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        space = new int[N][N];
        time = 0;
        sharkSize = 2;
        int minSize = 7;    // 최소 물고기 크기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 9) {
                    shark = new cor(i, j);
                    cur = 0;
                }
                if (cur != 0) {
                    fishNum[cur]++;
                    minSize = Math.min(minSize, cur);
                }
                space[i][j] = cur;
            }
        }
        while (!hungry) {
            boolean end = true;
            for (int i = minSize; i < Math.min(sharkSize, 7); i++) {
                if (fishNum[i] != 0) {
                    end = false;
                    minSize = i;
                    break;
                }
            }
            if (end) break;

            bfs();
        }

        System.out.println(time);

    }
    static int N, time, sharkSize, eaten;
    static int[][] space;
    static int[] fishNum = new int[7];
    static cor shark;
    static boolean hungry = false;
    static void bfs() {
        PriorityQueue<cor> pq = new PriorityQueue<>();
        Queue<cor> q2 = new LinkedList<>();
        cor tmp = new cor(shark.x, shark.y);
        pq.add(tmp);
        boolean[][] visit = new boolean[N][N];
        int currentTime = 0;

        while (!pq.isEmpty()) {

            while (!pq.isEmpty()) {
                cor cur = pq.remove();
                if (space[cur.x][cur.y] != 0 && space[cur.x][cur.y] < sharkSize) {
                    fishNum[space[cur.x][cur.y]]--;
                    space[cur.x][cur.y] = 0;
                    shark = cur;
                    eaten++;
                    if (eaten == sharkSize) {
                        sharkSize++;
                        eaten = 0;
                    }
                    time += currentTime;
                    return;
                }
                q2.add(cur);
            }

            while (!q2.isEmpty()) {
                cor cur = q2.remove();
                int x = cur.x;
                int y = cur.y;

                x--;
                if (x >= 0 && space[x][y] <= sharkSize && !visit[x][y]) {    // 위
                    visit[x][y] = true;
                    pq.add(new cor(x, y));
                }
                x++; y--;
                if (y >= 0 && space[x][y] <= sharkSize && !visit[x][y]) {   // 왼
                    visit[x][y] = true;
                    pq.add(new cor(x, y));
                }
                y++; y++;
                if (y < N && space[x][y] <= sharkSize && !visit[x][y]) {    // 오
                    visit[x][y] = true;
                    pq.add(new cor(x, y));
                }
                y--; x++;
                if (x < N && space[x][y] <= sharkSize && !visit[x][y]) {   // 아래
                    visit[x][y] = true;
                    pq.add(new cor(x, y));
                }
            }

            currentTime++;
        }
        if (tmp.x == shark.x && tmp.y == shark.y) {
            hungry = true;  // 먹이가 없는 곳만 탐색한 경우
        }
    }
}
class cor implements Comparable<cor> {
    int x, y;
    public cor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(cor o) {   // 위에 먹이 우선, 왼쪽먹이 차선
        if (x == o.x) {
            return y - o.y;
        } else {
            return x - o.x;
        }
    }
}