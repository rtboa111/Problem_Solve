package Problem_Solve;


import java.io.*;
import java.util.*;

public class _2887 {

    static class Node implements Comparable<Node> {
        int s, e, c;
        public Node(int s, int e, int c) {
            this.s = s; this.e = e; this.c = c;
        }
        @Override
        public int compareTo(Node o) {
            return c - o.c;
        }
    }
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] x = new int[n][2];
        int[][] y = new int[n][2];
        int[][] z = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i][0] = Integer.parseInt(st.nextToken());
            y[i][0] = Integer.parseInt(st.nextToken());
            z[i][0] = Integer.parseInt(st.nextToken());
            x[i][1] = i; y[i][1] = i; z[i][1] = i;
        }
        Arrays.sort(x, ((o1, o2) -> o1[0] - o2[0]));
        Arrays.sort(y, ((o1, o2) -> o1[0] - o2[0]));
        Arrays.sort(z, ((o1, o2) -> o1[0] - o2[0]));

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            pq.add(new Node(x[i-1][1], x[i][1], Math.abs(x[i-1][0] - x[i][0])));
            pq.add(new Node(y[i-1][1], y[i][1], Math.abs(y[i-1][0] - y[i][0])));
            pq.add(new Node(z[i-1][1], z[i][1], Math.abs(z[i-1][0] - z[i][0])));
        }
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;

        int cnt = 0;
        long res = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.remove();
            if (union(cur.s, cur.e)) {
                res += cur.c;
                cnt++;
                if (cnt == n-1) break;
            }
        }
        System.out.println(res);
    }
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) return false;
        parents[B] = A;
        return true;
    }
    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}