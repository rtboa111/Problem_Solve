package Problem_Solve;

import java.io.*;
import java.util.*;

public class _9370 {
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
    static int n, t, m, s, g, h;
    static final int MAX = (1 << 30);
    static ArrayList<ArrayList<Node>> path;
    static ArrayList<Integer> goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            path = new ArrayList<>(m*2);
            for (int j = 0; j < n; j++) {
                path.add(new ArrayList<>());
            }
            goal = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken())-1;
            g = Integer.parseInt(st.nextToken())-1;
            h = Integer.parseInt(st.nextToken())-1;
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int d = Integer.parseInt(st.nextToken());
                path.get(a).add(new Node(b, d));
                path.get(b).add(new Node(a, d));
            }
            for (int j = 0; j < t; j++) {
                goal.add(Integer.parseInt(br.readLine())-1);
            }
            goal.sort((o1, o2) -> o1 - o2);

            int[] sTo = dijkstra(s);
            int[] gTo = dijkstra(g);
            int[] hTo = dijkstra(h);
            int gLen = sTo[g];
            int hLen = sTo[h];
            int ghLen = gTo[h];

            for (int j : goal) {
                if ((gLen + ghLen + hTo[j] == sTo[j]) || (hLen + ghLen + gTo[j] == sTo[j])) {
                    bw.write((j+1)+" ");
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int[] dijkstra(int start) {
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

            for (Node n : path.get(cur)) {
                if (dist[n.end] > dist[cur] + n.cost) {
                    dist[n.end] = dist[cur] + n.cost;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }

        return dist;
    }
}