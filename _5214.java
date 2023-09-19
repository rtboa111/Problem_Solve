package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class _5214 {

    static ArrayList<LinkedList<Integer>> line;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        line = new ArrayList<>(n+1);
        board = new int[m][k];
        for (int i = 0; i <= n; i++) line.add(new LinkedList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int cur = Integer.parseInt(st.nextToken());
                board[i][j] = cur;
                line.get(cur).add(i);
            }
        }
        System.out.println(bfs(n, m));
    }
    static int bfs(int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        Integer[] visit = new Integer[m];
        Integer[] rank = new Integer[n+1];
        rank[1] = 1;
        for (int i : line.get(1)) {
            for (int j : board[i]) {
                if (rank[j] != null) continue;
                q.add(new int[]{j, 2});
                rank[j] = 2;
            }
            visit[i] = 2;
        }

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            for (int i : line.get(cur[0])) {
                if (visit[i] != null) continue;
                visit[i] = cur[1]+1;
                for (int j : board[i]) {
                    if (rank[j] != null) continue;
                    q.add(new int[]{j, cur[1]+1});
                    rank[j] = cur[1]+1;
                }
            }
        }

        return (rank[n] == null) ? -1 : rank[n];
    }
}
