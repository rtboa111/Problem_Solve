package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1956 {
    static final long MAX = (1L << 40);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        long[][] graph = new long[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = MAX;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            graph[s][e] = c;
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        long min = MAX;

        for (int i = 0; i < V; i++) {
            for (int j = i+1; j < V; j++) {
                if (graph[i][j] != MAX && graph[j][i] != MAX) {
                    min = Math.min(min, graph[i][j] + graph[j][i]);
                }
            }
        }

        System.out.println((min == MAX) ? -1 : min);
    }
}