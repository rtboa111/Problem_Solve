package Problem_Solve.Progermmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class unit_return {
    static ArrayList<ArrayList<Integer>> graph;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        graph = new ArrayList<>(n);
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] i : roads) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }

        return bfs(destination, sources, n);
    }

    static int[] bfs(int start, int[] sources, int n) {

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Integer[] visit = new Integer[n+1];
        visit[start] = 0;
        q.add(start);
        int cost = 0;
        while(!q.isEmpty()) {

            while(!q.isEmpty()) {
                q2.add(q.remove());
            }
            cost++;

            while(!q2.isEmpty()) {
                int cur = q2.remove();

                for(int i : graph.get(cur)) {
                    if(visit[i] == null) {
                        visit[i] = cost;
                        q.add(i);
                    }
                }
            }
        }
        int len = sources.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            res[i] = (visit[sources[i]] == null) ? -1 : visit[sources[i]];
        }
        return res;
    }
}