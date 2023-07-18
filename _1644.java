package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1644 {

    static final int MAX = 46340;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] sieve = new boolean[N+1];
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(0);
        int idx = 1;
        for (int i = 2; i <= N; i++) {
            if (!sieve[i]) {
                prefixSum.add(prefixSum.get(idx-1) + i);
                idx++;
                if (i >= MAX) continue;
                for (int j = (i * i); j <= N; j += i) {
                    sieve[j] = true;
                }
            }
        }
        int cnt = 0;
        int size = prefixSum.size();
        for (int i = 0, j = 1; j < size;) {
            int cur = prefixSum.get(j) - prefixSum.get(i);
            if (cur < N) {
                j++;
            } else {
                cnt += (cur == N) ? 1 : 0;
                i++;
            }
        }
        System.out.println(cnt);
    }
}