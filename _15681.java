package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _15681 {

    static ArrayList<LinkedList<Integer>> graph;
    static Integer[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        visit = new Integer[N+1];
        graph = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(visit[q]).append("\n");
        }
        System.out.println(sb);
    }
    static int dfs(int cur) {
        int sum = 1;
        visit[cur] = sum;
        for (int i : graph.get(cur)) {
            if (visit[i] == null) {
                 sum += dfs(i);
            }
        }
        return visit[cur] = sum;
    }
}