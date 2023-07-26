package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _20040 {

    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n];
        for (int i = 1; i < n; i++) {
            parents[i] = i;
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!union(a, b)) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
    static int find(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if(A == B) return false;

        parents[B] = A;
        return true;
    }
}