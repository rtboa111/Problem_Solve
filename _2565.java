package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2565 {

    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[501];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A] = B;
        }

        lis = new int[N+1];
        int lo = 0;
        int hi = 0;
        for (int i = 1; i <= 500; i++) {
            if (arr[i] == 0) continue;
            int idx = binarySearch(lo, hi+1, arr[i]);
            lis[idx] = arr[i];
            if (hi < idx) {
                hi = idx;
            }
        }

        System.out.println(N - hi);
    }
    static int binarySearch(int lo, int hi, int target) {

        while (lo < hi) {
            int mid = (hi + lo) / 2;

            if (target > lis[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}