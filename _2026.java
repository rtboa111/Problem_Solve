package Problem_Solve;

import java.io.*;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _2026 {
    static boolean flag;
    static int K, N, F, size;
    static StringBuilder sb;
    static boolean[] check;
    static ArrayList<Integer> list;
    static ArrayList<LinkedList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>(N+1);
        check = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int idx = 0;
        list = new ArrayList<>(N);
        for (LinkedList<Integer> i : graph) {
            if (i.size() >= K-1) {
                list.add(idx);
            }
            idx++;
        }

        flag = false;
        size = list.size();
        sb = new StringBuilder();
        dfs(0, 0, new Stack<>());

        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
    static void dfs(int idx, int cnt, Stack<Integer> cur) {
        if (flag) return;
        if (cnt == K) {
            if (check(cur)) {
                for (int i : cur) {
                    sb.append(i).append("\n");
                }
                flag = true;
            }
            return;
        }

        for (int i = idx; i < size; i++) {
            int num = list.get(i);
            cur.add(num);
            check[num] = true;
            dfs(i+1, cnt+1, cur);
            check[num] = false;
            cur.pop();
        }
    }
    static boolean check(Stack<Integer> cur) {
        for (int i : cur) {
            int cnt = 0;
            for (int j : graph.get(i)) {
                if (check[j]) cnt++;
            }
            if (cnt < K-1) {
                return false;
            }
        }
        return true;
    }
}

