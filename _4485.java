package Problem_Solve;

import java.io.*;
import java.util.*;

public class _4485 {

    static class Node implements Comparable<Node> {
        int end, coin;
        public Node(int end, int coin) {
            this.end = end;
            this.coin = coin;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.coin, o.coin);
        }
    }
    static int N;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 1;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            graph = new ArrayList<>(N*N);
            for (int i = 0; i < N*N; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int cur = Integer.parseInt(st.nextToken());
                    int x = i*N+j;
                    for (int k = 0; k < 4; k++) {
                        i += dx[k]; j += dy[k];

                        if (i >= 0 && j >= 0 && i < N && j < N) {
                            graph.get(i*N+j).add(new Node(x, cur));
                        }

                        i -= dx[k]; j -= dy[k];
                    }
                }
            }

            bw.write("Problem " + cnt + ": " + dijkstra() + "");
            bw.newLine();
            cnt++;
        }
        bw.flush();
        bw.close();
    }
    static final int max = (1 << 15);
    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N*N];
        int[] dist = new int[N*N];
        Arrays.fill(dist, max);
        dist[0] = graph.get(1).get(0).coin;
        pq.add(new Node(0, dist[0]));

        while (!pq.isEmpty()) {
            int cur = pq.remove().end;

            for (Node n : graph.get(cur)) {
                if (!visit[n.end] && dist[n.end] > dist[cur] + n.coin) {
                    visit[n.end] = true;
                    dist[n.end] = dist[cur] + n.coin;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }

        return dist[N*N-1];
    }
}