package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _1976 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (find(cur) != find(prev)) {
                System.out.println("NO");
                return;
            }
            prev = cur;
        }
        System.out.println("YES");
    }
    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) return;
        parents[A] = B;
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}