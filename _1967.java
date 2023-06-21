package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1967 {

    static int N, res;
    static boolean[] visit;
    static List<LinkedList<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
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
        res = 0;
        for (int i = 0; i < N; i++) {
            if (graph.get(i).size() > 1) {
                continue;
            }
            visit = new boolean[N];
            visit[i] = true;
            dfs(i, 0);
        }
        System.out.println(res);
    }
    static void dfs(int cur, int len) {
        res = Math.max(res, len);

        for (int[] i : graph.get(cur)) {
            if (!visit[i[0]]) {
                visit[i[0]] = true;

                dfs(i[0], len + i[1]);
            }
        }
    }
}