package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1865 {

    static class Edge {
        int v, w, cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }
    static int N, M, W;
    static ArrayList<Edge> linked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            linked = new ArrayList<>((M*2)+W);
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                linked.add(new Edge(s, e, T));
                linked.add(new Edge(e, s, T));
            }

            ArrayList<Integer> list = new ArrayList<>(W);
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                linked.add(new Edge(s, e, -T));
                list.add(e);
            }
            String res = "NO";
            for (int j : list) {
                if (BellmanFord(j)) {
                    res = "YES";
                    break;
                }
            }
            bw.write(res);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static boolean BellmanFord(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (M*2) + W; j++) {
                Edge edge = linked.get(j);

                if (dist[edge.v] != Integer.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        for (int i = 0; i < (M*2) + W; i++) {
            Edge edge = linked.get(i);

            if (dist[edge.v] != Integer.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost) {
                return true;
            }
        }
        return false;
    }
}