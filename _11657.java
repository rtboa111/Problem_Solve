package Problem_Solve;

import java.io.*;
import java.util.*;

public class _11657 {
    static class Node {
        int end, cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    static int n, m;
    static ArrayList<ArrayList<Node>> graph;
    static final long MAX = (1 << 28);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }
        long[] res = bellmanFord();

        if (res.length == 0) {
            bw.write(-1+"");
            bw.newLine();
        } else {
            for (int i = 1; i < n; i++) {
                if (res[i] == MAX) {
                    res[i] = -1;
                }
                bw.write(res[i]+"");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
    static long[] bellmanFord() {
        long[] dist = new long[n];
        Arrays.fill(dist, MAX);
        dist[0] = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                for (Node node : graph.get(i)) {
                    if (dist[i] != MAX && dist[node.end] > dist[i] + node.cost) {
                        if (dist[i] + node.cost < -MAX) {
                            return new long[0];
                        }
                        if (j == n-1) {
                            return new long[0];
                        }
                        dist[node.end] = dist[i] + node.cost;
                    }
                }
            }
        }

        return dist;
    }
}