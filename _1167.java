package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1167 {
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
    static int V, E;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        V = Integer.parseInt(br.readLine());
        E = 0;
        graph = new ArrayList<>(V);
        for (int i= 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e;
            while ((e = Integer.parseInt(st.nextToken())-1) >= 0) {
                int c = Integer.parseInt(st.nextToken());
                graph.get(s).add(new Node(e, c));
                graph.get(e).add(new Node(s, c));
            }
        }
        long[] a = dijkstra(0);
        long[] b = dijkstra((int) a[0]);

        System.out.println(b[1]);
    }
    static long[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] dist = new long[V];
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.remove();

            if (cur.cost > dist[cur.end]) {
                continue;
            }

            for (Node n : graph.get(cur.end)) {
                if (dist[n.end] > dist[cur.end] + n.cost) {
                    dist[n.end] = dist[cur.end] + n.cost;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }

        long[] ans = new long[2];
        for (int i = 0; i < V; i++) {
            if (ans[1] < dist[i]) {
                ans[0] = i;
                ans[1] = dist[i];
            }
        }
        return ans;
    }
}