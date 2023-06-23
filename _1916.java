package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1916 {
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
    static int n, m;
    static final int MAX = (1 << 30);
    static ArrayList<ArrayList<Node>> path;
    static ArrayList<Integer> goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        path = new ArrayList<>(m * 2);
        for (int j = 0; j < n; j++) {
            path.add(new ArrayList<>());
        }
        goal = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            path.get(s).add(new Node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(dijkstra(start, end));
    }
    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, MAX);
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node tmp = pq.remove();
            int cur = tmp.end;

            if (dist[cur] < tmp.cost) {
                continue;
            }
            if (cur == end) {
                break;
            }

            for (Node n : path.get(cur)) {
                if (dist[n.end] > dist[cur] + n.cost) {
                    dist[n.end] = dist[cur] + n.cost;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }

        return dist[end];
    }
}