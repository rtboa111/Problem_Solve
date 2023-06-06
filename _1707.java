package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1707 {

    static ArrayList<ArrayList<Integer>> linked;
    static int[] visit;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            linked = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                linked.add(new ArrayList<>());
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int form = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;
                linked.get(form).add(to);
                linked.get(to).add(form);
            }

            visit = new int[N];
            for (int j = 0; j < N; j++) {
                if (visit[j] == 0) {
                    visit[j] = 1;
                    dfs(j);
                }
            }

            if (N == 0) {
                bw.write("NO");
            } else {
                bw.write("YES");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int from) {

        for (Integer to : linked.get(from)) {
            if (visit[to] == 0) {
                visit[to] = visit[from] % 2 + 1;
                dfs(to);
            } else if (visit[from] % 2 + 1 != visit[to]) {
                N = 0;
                return;
            }
        }
    }
}