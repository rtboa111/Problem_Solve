package Problem_Solve;

import java.io.*;
import java.util.*;

public class _24838 {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n+1];
            int[] query = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= m; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                query[x]++;
                if (y == n) continue;
                query[y+1]--;
            }

            for (int j = 1; j <= n; j++) {
                query[j] += query[j-1];
            }
            Arrays.sort(query);
            Arrays.sort(arr);

            long sum = 0;
            long count = 1;
            int cnt = 1;
            for (int j = n, k = n; j >= 1; j--, k--) {
                if (query[j] <= 0) {
                    while (j >= 1 && query[j] == 0) {
                        j--;
                        cnt++;
                    }
                    cnt--;
                    while (cnt > 1) {
                        count = (count * cnt--) % MOD;
                    }
                    break;
                }
                sum += (long) query[j] * arr[k];
                if (query[j] != query[j-1]) {
                    while (cnt > 1) {
                        count = (count * cnt--) % MOD;
                    }
                    continue;
                }
                cnt++;
            }
            sb.append(sum).append(" ").append(count % MOD).append("\n");
        }
        System.out.println(sb);
    }
}

