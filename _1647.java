package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1647 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<int[]> arr = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new int[]{a, b, c});
        }
        arr.sort(((o1, o2) -> o1[2] - o2[2]));
        parents = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        int cnt = 0;
        long cost = 0;
        for (int[] i : arr) {
            if (union(i[0], i[1])) {
                if (cnt >= n-2) break;
                cost += i[2];
                cnt++;
            }
        }
        System.out.println(cost);
    }
    static int[] parents;
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return false;
        parents[B] = A;
        return true;
    }
    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}