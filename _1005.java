package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1005 {
    static boolean[] check;
    static ArrayList<Integer> times;
    static ArrayList<ArrayList<Integer>> prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            check = new boolean[N];
            times = new ArrayList<>(N);
            prev = new ArrayList<>(N);
            for (int j = 0; j < N; j++) {
                prev.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                times.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                prev.get(y).add(x);
            }
            int w = Integer.parseInt(br.readLine())-1;
            sb.append(dfs(w)).append("\n");
        }

        System.out.print(sb);
    }
    static public int dfs(int cur) {
        if (check[cur]) {
            return times.get(cur);
        }

        int max = 0;
        for (Integer i : prev.get(cur)) {
            max = Math.max(max, dfs(i));
        }

        check[cur] = true;
        times.set(cur, times.get(cur) + max);
        return times.get(cur);
    }
}