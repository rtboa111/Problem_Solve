package Problem_Solve;

import java.io.*;
import java.util.*;

public class _24480_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken())-1;
        link = new ArrayList<>(N);
        count = new int[N];
        for (int i = 0; i < N; i++) {
            link.add(new PriorityQueue<>(Collections.reverseOrder()));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            link.get(a).add(b);
            link.get(b).add(a);
        }
        time = 1;
        dfs(R);

        for (int i : count) {
            bw.write(i+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int N, time;
    static int[] count;
    static ArrayList<PriorityQueue<Integer>> link;
    static void dfs(int cur) {
        if (count[cur] == 0) {
            count[cur] = time++;
        }
        PriorityQueue<Integer> x = link.get(cur);
        while (!x.isEmpty()) {
            int tmp = x.poll();
            PriorityQueue<Integer> y = link.get(tmp);
            y.remove(cur);
            if (count[tmp] == 0) {
                dfs(tmp);
            }
        }
    }
}