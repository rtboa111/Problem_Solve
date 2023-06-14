package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2110 {

    static int N, C;
    static int[] cordi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cordi = new int[N];
        for (int i = 0; i < N; i++) {
            cordi[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cordi);

        int res;
        if (N == 2) {
            res = cordi[N-1] - cordi[0];
        } else {
            res = binarySearch(0, cordi[N-1]);
        }

        System.out.println(res);
    }
    static int binarySearch(int lo, int hi) {
        while (lo < hi) {
            int mid = (hi + lo) / 2;

            int cnt = install(mid);

            if (cnt <= 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo - 1;
    }
    static int install(int mid) {
        int s = cordi[0];
        int cnt = C - 1;
        for (int i = 1; i < N; i++) {
            if (cordi[i] - s >= mid) {
                s = cordi[i];
                cnt--;
            }
        }

        return cnt;
    }
}