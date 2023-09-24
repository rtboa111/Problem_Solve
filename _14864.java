package Problem_Solve;

import java.io.*;
import java.util.*;

public class _14864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] res = new int[N+1];
        for (int i = 1; i <= N; i++) res[i] = i;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            res[x]++; res[y]--;
        }
        boolean[] check = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (check[res[i]]) {
                System.out.println(-1);
                return;
            }
            check[res[i]] = true;
        }

        for (int i = 1; i <= N; i++) {
            bw.write(res[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}