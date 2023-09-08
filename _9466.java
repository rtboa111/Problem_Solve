package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _9466 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n; int[] arr;
        ArrayList<LinkedList<Integer>> graph;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            graph = new ArrayList<>(n+1);
            arr = new int[n+1];
            for (int a = 0; a <= n; a++) {
                graph.add(new LinkedList<>());
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int a = 1; a <= n; a++) {
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                arr[b]++;
            }

            Queue<Integer> q = new LinkedList<>();
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[j] != 0) continue;
                q.add(j); cnt++;
            }
            while (!q.isEmpty()) {
                int cur = q.remove();
                for (int j : graph.get(cur)) {
                    if (--arr[j] != 0) continue;
                    q.add(j); cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
