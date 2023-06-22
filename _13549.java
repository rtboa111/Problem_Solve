package Problem_Solve;

import java.io.*;
import java.util.*;

public class _13549 {
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
    static int n, k;
    static final int MAX = 100000;
    static ArrayList<ArrayList<Node>> path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        path = new ArrayList<>(MAX+1);
        for (int i = 0; i <= MAX; i++) {
            path.add(new ArrayList<>());
        }
        path.get(0).add(new Node(1, 1));

        for (int i = 1; i < MAX; i++) {
            path.get(i).add(new Node(i-1, 1));
            path.get(i).add(new Node(i+1, 1));
            if (i << 1 <= MAX) {
                path.get(i).add(new Node(i << 1, 0));
            }
        }
        path.get(MAX).add(new Node(MAX-1, 1));

        System.out.println(dijkstra());
    }
    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));
        int[] dist = new int[MAX+1];
        Arrays.fill(dist, MAX);
        dist[n] = 0;

        while(!pq.isEmpty()) {
            Node tmp = pq.remove();
            int cur = tmp.end;

            if (dist[cur] < tmp.cost) {
                continue;
            }
            if (cur == k) {
                break;
            }

            for (Node n : path.get(cur)) {
                if (dist[n.end] > dist[cur] + n.cost) {
                    dist[n.end] = dist[cur] + n.cost;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }
        return dist[k];
    }
}