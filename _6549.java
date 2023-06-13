package Problem_Solve;

import java.io.*;
import java.util.*;

public class _6549 {

    static int[] histogram;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while ((st = new StringTokenizer(br.readLine())).countTokens() != 1) {
            N = Integer.parseInt(st.nextToken());

            histogram = new int[N];
            for (int i = 0; i < N; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            bw.write(divideAndConquer(0, N)+"");
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
    static long divideAndConquer(int lo, int hi) {
        if (lo == hi) return 0;
        if (lo+1 == hi) return histogram[lo];

        int ran = 1, mid = (hi + lo) / 2, left = mid, right = mid, minH = histogram[mid];

        long leftRes = divideAndConquer(lo, mid);
        long rightRes = divideAndConquer(mid, hi);
        long res = ran * minH;

        while (lo <= left && right < hi) {
            int lH = (left - 1 >= 0) ? histogram[left-1] : 0;
            int rH = (right + 1 < N) ? histogram[right+1] : 0;
            int curH;

            if (lH == 0 && rH == 0) {
                break;
            }

            if (lH >= rH) {
                left--;
                curH = lH;
            } else {
                right++;
                curH = rH;
            }

            minH = Math.min(minH, curH);
            ran++;

            res = Math.max(res, (long) ran * minH);
        }

        return Math.max(res, Math.max(rightRes, leftRes));
    }
}