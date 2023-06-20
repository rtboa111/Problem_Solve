package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1504 {

    static class Node implements Comparable<Node> {
        int end, cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int N, E;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>(E);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken())-1;
            int l = Integer.parseInt(st.nextToken());
            graph.get(v).add(new Node(w, l));
            graph.get(w).add(new Node(v, l));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken())-1;
        int v2 = Integer.parseInt(st.nextToken())-1;

        int res = dijkstra(v1, v2);
        int a = dijkstra(0, v1), b = dijkstra(0, v2), c = dijkstra(N-1, v1), d = dijkstra(N-1, v2);

        res = Math.min(res + a + d, Math.min(res + b + c, Math.min(res*2 + a + c, res*2 + b + d)));

        if (res >= max) {
            res = -1;
        }

        System.out.println(res);
    }
    static final int max = Integer.MAX_VALUE >> 3;
    static int dijkstra(int s, int e) {

        boolean[] visit = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, max);
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.remove();

            if (visit[cur.end]) continue;

            visit[cur.end] = true;

            for (Node n : graph.get(cur.end)) {
                if (dist[n.end] > dist[cur.end] + n.cost) {
                    dist[n.end] = dist[cur.end] + n.cost;

                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }

        return dist[e];
    }
}