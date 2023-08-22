package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _2213 {

    static int[] node;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>[]> nodes;
    static ArrayList<LinkedList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = new int[N+1];
        graph = new ArrayList<>(N+1);
        nodes = new ArrayList<>(N+1);
        graph.add(new LinkedList<>());
        nodes.add(new ArrayList[2]);
        for (int i = 1; i <= N; i++) {
            node[i] = Integer.parseInt(st.nextToken());
            graph.add(new LinkedList<>());
            nodes.add(new ArrayList[2]);
        }

        String str;
        while (true) {
            str = br.readLine();
            if (str == null) break;
            st = new StringTokenizer(str);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visit = new boolean[N+1];
        int[] ans = dfs(1);
        bw.write(String.valueOf(Math.max(ans[0], ans[1])));
        bw.newLine();
        ArrayList<Integer>[] res = nodes.get(1);
        if (ans[0] > ans[1]) {
            res[0].sort(Integer::compare);
            for (int i : res[0]) {
                bw.write(i + " ");
            }
        } else {
            res[1].sort(Integer::compare);
            for (int i : res[1]) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }
    static int[] dfs(int cur) {
        visit[cur] = true;
        int[] curP = {node[cur], 0};
        ArrayList<Integer>[] arr = nodes.get(cur);
        arr[0] = new ArrayList<>();
        arr[1] = new ArrayList<>();
        arr[0].add(cur);
        for (int i : graph.get(cur)) {
            if (!visit[i]) {
                int[] tmp = dfs(i);
                curP[0] += tmp[1];
                arr[0].addAll(nodes.get(i)[1]);
                if (tmp[0] > tmp[1]) {
                    curP[1] += tmp[0];
                    arr[1].addAll(nodes.get(i)[0]);
                } else {
                    curP[1] += tmp[1];
                    arr[1].addAll(nodes.get(i)[1]);
                }
            }
        }
        return curP;
    }
}