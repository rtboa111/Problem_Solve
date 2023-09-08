package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>(N+1);
        for (int i = 0 ; i <= N; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            arr[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1 ; i <= N; i++) {
            if (arr[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.remove();
            bw.write(cur + " ");
            for (int i : graph.get(cur)) {
                if (--arr[i] == 0) q.add(i);
            }
        }
        bw.flush();
        bw.close();
    }
}