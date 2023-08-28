package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2166 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x0 = Integer.parseInt(st.nextToken());
        long y0 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] prev = new long[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        double res = 0;
        for (int i = 2; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            res += ccw(x0, y0, prev[0], prev[1], x, y);
            prev[0] = x; prev[1] = y;
        }
        System.out.printf("%.1f", Math.abs(res));
    }
    static double ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        double ans = x1*y2 + x2*y3 + x3*y1;
        ans -= x2*y1 + x3*y2 + x1*y3;
        return ans / 2;
    }
}