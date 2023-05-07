package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _1260 {

    static boolean[] check,check2;
    static int N;
    static boolean[][] connection;
    static Queue<Integer> q = new LinkedList<Integer>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 정점 수
        int M = Integer.parseInt(st.nextToken());   // 엣지 수
        int V = Integer.parseInt(st.nextToken());   // 탐색 시작 정점
        connection = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            connection[from][to] = true;
            connection[to][from] = true;
        }
        check = new boolean[N+1];
        dfs(V);

        sb.append("\n");

        check = new boolean[N+1];
        check2 = new boolean[N+1];
        q.add(V);
        check2[V] = true;
        while(q.peek()!=null) {
            int a = q.poll();
            if(!check[a]) {
                bfs(a);
            }
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        sb.append(start).append(" ");
        check[start] = true;
        for (int i = 1; i <= N; i++) {
            if(connection[start][i]&&!check[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        sb.append(start).append(" ");
        check[start] = true;    // 탐색 완료한 정점 체크
        for(int i = 1; i <= N;i++) {
            if(connection[start][i]&&!check[i]&&!check2[i]) {
                check2[i] = true;   // queue 에 올라간 정점 체크
                q.add(i);
            }
        }
    }
}