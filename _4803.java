package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _4803 {

    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;

            parents = new int[n+1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }
            boolean[] check = new boolean[n+1];

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int A = find(a);
                int B = find(b);
                if(!union(a, b) || check[A] || check[B]) {
                    check[A] = true;
                    check[B] = true;
                }
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                int I = find(i);
                if (!check[I]) {
                    check[I] = true;
                    cnt++;
                }
            }

            bw.write("Case " + T + ": ");

            if (cnt == 0) {
                bw.write("No trees.");
            } else if (cnt == 1) {
                bw.write("There is one tree.");
            } else {
                bw.write("A forest of " + cnt + " trees.");
            }
            bw.newLine();
            T++;
        }
        bw.flush();
        bw.close();
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