package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _2533 {

    static boolean[] visit;
    static ArrayList<LinkedList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) graph.add(new LinkedList<>());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visit = new boolean[N+1];
        int[] ans = dfs(1);
        System.out.println(Math.min(ans[0], ans[1]));
    }
    static int[] dfs(int cur) {
        visit[cur] = true;
        int[] curP = {1, 0};
        for (int i : graph.get(cur)) {
            if (!visit[i]) {
                int[] tmp = dfs(i);
                curP[0] += Math.min(tmp[0], tmp[1]);
                curP[1] += tmp[0];
            }
        }

        return curP;
    }
}