package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] prefixSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            prefixSum[i] = cur + prefixSum[i-1];
        }

        int len = N+1;
        for (int i = 0, j = 1; j <= N; ) {
            int cur = prefixSum[j] - prefixSum[i];
            if (cur < S) {
                j++;
            } else {
                len = Math.min(len, j - i);
                i++;
            }
        }
        System.out.println((len > N) ? 0 : len);
    }
}