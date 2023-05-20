package Problem_Solve;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1389 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] relations = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            relations[a][b] = true;
            relations[b][a] = true;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {

            boolean[] check = new boolean[N];
            check[i] = true;
            for (int j = 0; j < N; j++) {
                if (relations[i][j]) {
                    check[j] = true;
                    q.add(j);
                }
            }

            bfs(check, q, relations, i);
        }

        System.out.println(result+1);
    }

    static int count = Integer.MAX_VALUE;
    static int result = Integer.MAX_VALUE;
    static void bfs(boolean[] check, Queue<Integer> q, boolean[][] relations, int target) {
        Queue<Integer> q2 = new LinkedList<>();
        int vaganN = 0;
        int step = 1;
        while (!q.isEmpty()) {

            vaganN += step * q.size();

            while (!q.isEmpty()) {
                int num = q.remove();
                q2.add(num);
            }

            step++;

            while (!q2.isEmpty()) {
                int cur = q2.remove();
                for (int i = 0; i < check.length; i++) {
                    if (relations[cur][i] && !check[i]) {
                        q.add(i);
                        check[i] = true;
                    }
                }
            }
        }
        if (count > vaganN || (count == vaganN && result > target)) {
            count = vaganN;
            result = target;
        }
    }
}