package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _11725 {

    static int[] parent;
    static ArrayList<ArrayList<Integer>> linked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        linked = new ArrayList<>(N);
        for (int i = 0; i <= N; i++) {
            linked.add(new ArrayList<>());
        }
        parent = new int[N+1];
        parent[1] = 1;
        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            linked.get(u).add(v);
            linked.get(v).add(u);
        }

        bfs();

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i]+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {

            int cur = q.remove();
            ArrayList<Integer> curLink = linked.get(cur);
            for (int i : curLink) {
                if (parent[i] == 0) {
                    parent[i] = cur;
                    q.add(i);
                }
            }
        }
    }
}