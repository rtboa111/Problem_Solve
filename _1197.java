package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1197 {
    static class Node implements Comparable<Node> {
        int s, e, cost;
        public Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<Node> graph = new ArrayList<>(V);
        parents = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Node(s, e, c));
        }

        graph.sort(Node::compareTo);
        int cost = 0;
        int cnt = 0;
        for (Node n : graph) {
            if (union(n.s, n.e)) {
                cost += n.cost;
                cnt++;
                if (cnt == V-1) {
                    System.out.println(cost);
                    return;
                }
            }
        }
    }
    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return false;

        parents[B] = A;
        return true;
    }
}