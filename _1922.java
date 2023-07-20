package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1922 {
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
    static ArrayList<Node> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(N);
        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Node(s, e, c));
        }
        graph.sort(Node::compareTo);
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        int cnt = 0;
        int cost = 0;
        for (Node i : graph) {
            if (union(i.s, i.e)) {
                cost += i.cost;
                cnt++;
                if (cnt > N) {
                    break;
                }
            }
        }
        System.out.println(cost);
    }
    static int[] parent;
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) {
            return false;
        }
        parent[A] = B;
        return true;
    }
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }
}