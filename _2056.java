package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2056 {
    static boolean[] check;
    static ArrayList<Integer> times;
    static ArrayList<ArrayList<Integer>> prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        check = new boolean[N];
        times = new ArrayList<>(N);
        prev = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times.add(Integer.parseInt(st.nextToken()));
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>(k);
            for (int j = 0; j < k; j++) {
                arr.add(Integer.parseInt(st.nextToken())-1);
            }
            check[i] = (arr.size() == 0);
            prev.add(arr);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dfs(i));
        }
        System.out.print(max);
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