package Problem_Solve;
import java.io.*;
import java.util.StringTokenizer;

public class _1717 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(o == 0) {
                union(a, b);
            } else {
                int A = find(a);
                int B = find(b);
                bw.write((A == B) ? "YES" : "NO");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if(A == B) return;

        if(A < B) {
            parents[B] = A;
        } else {
            parents[A] = B;
        }
    }

    static int find(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}