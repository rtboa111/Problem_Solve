package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _13899 {

    static ArrayList<LinkedList<int[]>> graph;
    static ArrayList<long[]> cor;
    static Integer[] visit;
    static long minX, minY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>(N+1);
        cor = new ArrayList<>(N+1);
        ArrayList<long[]> base = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
            cor.add(new long[2]);
            base.add(new long[2]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, dx, dy});
            graph.get(b).add(new int[]{a, -dx, -dy});
        }

        visit = new Integer[N+1];
        for (int i = 1; i <= N; i++) {
            if (visit[i] == null) {
                minX = 1L << 60;
                minY = 1L << 60;
                dfs(i, i, 0, 0);
                base.get(i)[0] = -minX;
                base.get(i)[1] = -minY;
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write((cor.get(i)[0] + base.get(visit[i])[0]) + " " + (cor.get(i)[1] + base.get(visit[i])[1]));
            bw.newLine();
        }
        bw.flush();
    }
    static void dfs(int base, int cur, long x, long y) {
        visit[cur] = base;
        cor.get(cur)[0] = x;
        cor.get(cur)[1] = y;
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);

        for (int[] i : graph.get(cur)) {
            int idx = i[0];
            if (visit[idx] == null) {
                dfs(base, idx, x + i[1], y + i[2]);
            }
        }
    }
}
