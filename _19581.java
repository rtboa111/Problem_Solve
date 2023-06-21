package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _19581 {

    static int N;
    static List<LinkedList<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(N+1);
        for (int i = 0; i < N; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[]{e, c});
            graph.get(e).add(new int[]{s, c});
        }
        a = b = -1;

        a = bfs(0)[0];
        b = bfs(a)[0];

        System.out.println(Math.max(bfs(a)[1], bfs(b)[1]));
    }

    static int a, b;
    static int[] bfs(int s) {
        int[] res = new int[2];

        Queue<int[]> q = new LinkedList<>();
        Integer[] dist = new Integer[N];
        dist[s] = 0;
        q.add(new int[]{s, 0});

        while (!q.isEmpty()) {
            int cur = q.remove()[0];

            for (int[] n : graph.get(cur)) {
                if (dist[n[0]] == null) {
                    dist[n[0]] = dist[cur] + n[1];
                    q.add(new int[]{n[0], dist[n[0]]});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (i != a && i != b && dist[i] > res[1]) {
                res[1] = dist[i];
                res[0] = i;
            }
        }

        return res;
    }
}