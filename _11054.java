package Problem_Solve;

import java.io.*;
import java.util.*;

public class _11054 {

    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] reversArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0,j = N-1; i < N; i++,j--) {
            arr[i] = Integer.parseInt(st.nextToken());
            reversArr[j] = arr[i];
        }

        int max = 0;
        for (int k = 0; k < N; k++) {
            lis = new int[N+1];
            lis[0] = arr[k];
            int lo = 0;
            int hi = 0;
            for (int i = k+1; i < N; i++) {
                int idx = binarySearchDC(lo, hi+1, arr[i]);
                lis[idx] = arr[i];
                if (hi < idx) {
                    hi = idx;
                }
            }
            int dp = hi+1;

            lo = 0;
            hi = 0;
            lis = new int[N+1];
            lis[0] = reversArr[N-1-k];
            for (int i = N-k; i < N; i++) {
                int idx = binarySearchDC(lo, hi+1, reversArr[i]);
                lis[idx] = reversArr[i];
                if (hi < idx) {
                    hi = idx;
                }
            }
            dp += hi;

            max = Math.max(max, dp);
        }
        System.out.println(max);
    }
    static int binarySearchDC(int lo, int hi, int target) {

        while (lo < hi) {
            int mid = (hi + lo) / 2;

            if (target < lis[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}