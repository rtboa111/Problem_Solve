package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        link = new boolean[N][N];
        result = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    link[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            java.util.Queue<Integer> q = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                if (link[i][j]) {
                    q.add(j);
                }
            }
            bfs(i, q);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (link[i][j]) {
                    bw.write(1+" ");
                } else {
                    bw.write(0+" ");
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int N;
    static boolean[][] link;
    static boolean[][] result;
    static void bfs(int cur, Queue<Integer> q) {
        boolean[] check = new boolean[N];
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int i = 0; i < N; i++) {
                if (!check[i] && link[x][i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (check[i]) {
                link[cur][i] = true;
            }
        }
    }
}