package Problem_Solve;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _21736 {

    static char[][] campus;
    static boolean[][] visit;
    static int N, M, start, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (input[j] == 'I') {
                    start = i*M+j;
                }
                campus[i][j] = input[j];
            }
        }

        bfs();

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            while (!q.isEmpty()) {
                q2.add(q.remove());
            }

            while (!q2.isEmpty()) {

                int cur = q2.remove();
                int x = cur / M;
                int y = cur % M;

                x++;
                if (x < N && !visit[x][y] && campus[x][y] < 'X') {
                    q.add(x*M+y);
                    visit[x][y] = true;
                    if (campus[x][y] == 'P') {
                        count++;
                    }
                }

                x--; y++;
                if (y < M && !visit[x][y] && campus[x][y] < 'X') {
                    q.add(x*M+y);
                    visit[x][y] = true;
                    if (campus[x][y] == 'P') {
                        count++;
                    }
                }

                y--; x--;
                if (x >= 0 && !visit[x][y] && campus[x][y] < 'X') {
                    q.add(x*M+y);
                    visit[x][y] = true;
                    if (campus[x][y] == 'P') {
                        count++;
                    }
                }

                x++; y--;
                if (y >= 0 && !visit[x][y] && campus[x][y] < 'X') {
                    q.add(x*M+y);
                    visit[x][y] = true;
                    if (campus[x][y] == 'P') {
                        count++;
                    }
                }
            }
        }
    }
}