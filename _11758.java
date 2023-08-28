package Problem_Solve;

import java.io.*;
import java.util.*;

public class _11758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] cordi = new int[6];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cordi[i] = x; cordi[i+3] = y;
        }
        System.out.println(ccw(cordi[0], cordi[3], cordi[1], cordi[4], cordi[2], cordi[5]));
    }
    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long ans = x1*y2 + x2*y3 + x3*y1;
        ans -= x2*y1 + x3*y2 + x1*y3;
        if (ans > 0) return 1;
        if (ans < 0) return -1;
        return 0;
    }
}