package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1753 {
    static class Node implements Comparable<Node> {
        int end, cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    static int v, e;
    static final int INF = (1 << 30);
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine())-1;
        graph = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }

        for (int i : dijkstra(start)) {
            if (i == INF) {
                bw.write("INF");
            } else {
                bw.write(i+"");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        int[] dist = new int[v];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node tmp = pq.remove();
            int cur = tmp.end;

            if (dist[cur] < tmp.cost) {
                continue;
            }

            for (Node n : graph.get(cur)) {
                if (dist[n.end] > dist[cur] + n.cost) {
                    dist[n.end] = dist[cur] + n.cost;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }
        return dist;
    }
}