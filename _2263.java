package Problem_Solve;

import java.io.*;
import java.util.stream.Stream;

public class _2263 {
    static int n;
    static StringBuilder sb;
    static boolean[] check;
    static int[] in, post;
    static int[][] relation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        in = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        post = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        relation = new int[n+1][2];
        check = new boolean[n];
        int start = divideAndConquer(0, n-1,  n-1);
        sb = new StringBuilder();
        dfs(start);
        System.out.println(sb);
    }
    static void dfs(int cur) {
        if (cur == 0) return;
        sb.append(cur).append(" ");
        dfs(relation[cur][0]);
        dfs(relation[cur][1]);
    }

    static Integer divideAndConquer(int lo, int hi, int pointer) {
        if (lo > hi || pointer < 0) return 0;

        int parents = post[pointer];
        check[pointer] = true;

        if (lo == hi) {
            return in[lo];
        }
        int num = lo;
        while (in[num] != parents) {
            num++;
        }

        while (pointer >= 0 && check[pointer]) {
            pointer--;
        }

        relation[parents][1] = divideAndConquer(num+1, hi, pointer);

        while (pointer >= 0 && check[pointer]) {
            pointer--;
        }

        relation[parents][0] = divideAndConquer(lo, num-1, pointer);

        return parents;
    }
}