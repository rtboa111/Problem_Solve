package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _11780 {

    static final int INF = (1 << 28);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][n+1];
        ArrayList<ArrayList<LinkedList<Integer>>> list = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>(n));
            Arrays.fill(dp[i], INF);
            for (int j = 0; j <= n; j++) {
                list.get(i).add(new LinkedList<>());
            }
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (dp[s][e] > c) {
                dp[s][e] = c;
                list.get(s).set(e, new LinkedList<>());
                list.get(s).get(e).add(s);
                list.get(s).get(e).add(e);
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) {
                    dp[i][k] = 0;
                }
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        LinkedList<Integer> cur = new LinkedList<>();
                        cur.addAll(list.get(i).get(k));
                        cur.removeLast();
                        cur.addAll(list.get(k).get(j));
                        list.get(i).set(j, cur);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write(dp[i][j] + " ");
            }
            bw.newLine();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int size = list.get(i).get(j).size();
                if (size <= 1) {
                    bw.write(0 + " ");
                } else {
                    bw.write(size + " ");
                    for (int k : list.get(i).get(j)) {
                        bw.write(k + " ");
                    }
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}