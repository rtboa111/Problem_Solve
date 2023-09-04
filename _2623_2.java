package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Stack;
import java.util.Queue;

public class _2623_2 {

    static int N;
    static ArrayList<LinkedList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }

        int[] num = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 1; j < n; j++) {
                int b = Integer.parseInt(st.nextToken());
                graph.get(b).add(a);
                num[a]++;
                a = b;
            }
        }

        Stack<Integer> res = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (num[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int cur = q.remove();
            res.add(cur);
            for (int i : graph.get(cur)) {
                if (--num[i] == 0) q.add(i);
            }
        }
        if (res.size() < N) {
            System.out.println(0);
            return;
        }
        while (!res.isEmpty()) {
            bw.write(String.valueOf(res.pop()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
