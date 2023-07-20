package Problem_Solve;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1450 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int len1 = 1 << (N - N/2);
        int len2 = 1 << (N/2);
        long[] half1 = bitMasking(arr, len1, 0, N - N/2);
        long[] half2 = bitMasking(arr, len2,  N - N/2, N/2);
        Arrays.sort(half2);

        long res = 0;
        for (long i : half1) {
            i = C - i;
            int idx = binarySearch(0, len2, i, half2);
            res += idx;
        }

        System.out.println(res);
    }
    static long[] bitMasking(long[] arr, int len, int start, int end) {
        long[] ans = new long[len];

        for (int i = 0; i < len; i++) {
            long tmp = 0;
            for (int j = 0; j < end; j++) {
                if ((i & (1 << j)) != 0) {
                    tmp += arr[j + start];
                }
            }
            ans[i] = tmp;
        }
        return ans;
    }
    static int binarySearch(int lo, int hi, long target, long[] arr) {
        while (lo < hi) {
            int mid =(hi + lo) / 2;

            if (target >= arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}