package Problem_Solve;

import java.io.*;

public class _1300 {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(1, K));
    }
    /*
     * i행의 값들은 i*x(x <= N) 형태이므로
     * Math.min(mid / i, N)개의 원소는 mid 보다 작은
     * 값임이 보장됨
     */
    static long binarySearch(long lo, long hi) {
        while (lo < hi) {
            long mid = (hi + lo) / 2;

            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
            if (cnt < K) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}