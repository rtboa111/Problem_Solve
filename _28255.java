package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _28255 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] cnt = new long[2];
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur > 1) {
                continue;
            }
            cnt[cur]++;
        }
        long res = comb(cnt[0]) + (cnt[0] * cnt[1] * 2) + (cnt[0] * (N - cnt[0] - cnt[1]));
        System.out.println(res);
    }
    static long comb(long n) {
        return n*(n-1)/2;
    }
}