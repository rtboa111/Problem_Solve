package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1368 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> graph = new ArrayList<>(n*(n+1));
        parents = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int c = Integer.parseInt(br.readLine());
            graph.add(new int[]{0, i, c});
            parents[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (i == j) {
                    continue;
                }
                graph.add(new int[]{i, j, c});
            }
        }

        graph.sort((o1, o2) -> o1[2] - o2[2]);

        int cnt = 0;
        int res = 0;
        for (int[] cur : graph) {
            if (union(cur[0], cur[1])) {
                res += cur[2];
                cnt++;
                if (cnt == n) {
                    System.out.println(res);
                    return;
                }
            }
        }
    }
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) {
            return false;
        }

        if (A < B) {
            parents[B] = A;
        } else {
            parents[A] = B;
        }
        return true;
    }
    static int find(int a) {
        if (a == parents[a]) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
}