package Problem_Solve;

import java.io.*;
import java.util.*;

public class _11779 {
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
    static int n;
    static long Cost;
    static final long INF = (1L << 32);
    static boolean[] check;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;


        StringBuilder sb = new StringBuilder();
        check = new boolean[n];
        ArrayList<long[]> rute = dijkstra(start, end);
        int size = 1;
        check[end] = true;
        loop:
        for (int i = rute.size()-1, j = i-1; j >= 0; j--) {
            for (Node n : graph.get((int) rute.get(j)[0])) {
                if (n.end == rute.get(i)[0] && n.cost == rute.get(i)[1] - rute.get(j)[1]) {
                    check[(int) rute.get(j)[0]] = true;
                    i = j;
                    size++;
                    continue loop;
                }
            }
        }

        sb.append(rute.get(rute.size()-1)[1]).append("\n").append(size).append("\n");

        for (long[] i : rute) {
            if (check[(int) i[0]]) {
                sb.append(i[0]+1).append(" ");
            }
        }
        System.out.println(sb);
    }
    static ArrayList<long[]> dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        ArrayList<long[]> rute = new ArrayList<>(n);

        while(!pq.isEmpty()) {
            Node cur = pq.remove();

            if (cur.cost > dist[cur.end]) {
                continue;
            }

            rute.add(new long[]{cur.end, cur.cost});

            if (cur.end == end) {
                Cost = dist[end];
                break;
            }

            for (Node n : graph.get(cur.end)) {
                if (dist[n.end] > dist[cur.end] + n.cost) {
                    dist[n.end] = dist[cur.end] + n.cost;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }
        return rute;
    }
}