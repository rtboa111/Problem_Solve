package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1414 {

    static final int INF = (1 << 20);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> graph = new ArrayList<>(N*N/2);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            char[] length = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                char cur = length[j];
                int num = INF;
                if (cur >= 'a') {
                    num = (length[j]) - 'a' + 1;
                } else if (cur >= 'A') {
                    num = (length[j]) - 'A' + 27;
                }
                if (num == INF) {
                    continue;
                }
                sum += num;
                graph.add(new int[]{i, j, num});
            }
        }

        graph.sort((o1, o2) -> o1[2] - o2[2]);

        parent = new int[N];
        for (int i = 1; i < N; i++) parent[i] = i;

        int minimum = 0, cnt = 0;
        for (int[] i : graph) {
            if (union(i[0], i[1])) {
                minimum += i[2];
                cnt++;
                if (cnt == N-1) break;
            }
        }

        System.out.println((cnt == N-1) ? sum - minimum : -1);
    }
    static int[] parent;
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) {
            return false;
        }
        if (A < B) {
            parent[B] = A;
        } else {
            parent[A] = B;
        }
        return true;
    }
    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}