package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1238 {
    static class Node implements Comparable<Node> {
        int end;
        long cost;
        public Node(int end, long cost) {
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(cost, o.cost);
        }
    }
    static final long MAX = (1L << 40);
    static int N, M, X;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;
        graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, t));
        }

        long[] dist = dijkstra(X, -1);
        long res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dist[i] + dijkstra(i, X)[0]);
        }

        System.out.println(res);
    }
    static long[] dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] dist = new long[N];
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.remove();

            if (cur.cost > dist[cur.end]) {
                continue;
            }
            if (cur.end == end) {
                return new long[]{dist[end]};
            }

            for (Node n : graph.get(cur.end)) {
                if (dist[n.end] > dist[cur.end] + n.cost) {
                    dist[n.end] = dist[cur.end] + n.cost;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }

        return dist;
    }
}