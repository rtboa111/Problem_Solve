package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _12015 {

    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        lis = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];

        int lo = 0;
        int hi = 1;
        for (int i = 1; i < N; i++) {
            if (lis[hi-1] < arr[i]) {
                lis[hi] = arr[i];
                hi++;
            } else {
                int idx = binarySearch(lo, hi, arr[i]);
                lis[idx] = arr[i];
            }
        }

        System.out.println(hi);
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