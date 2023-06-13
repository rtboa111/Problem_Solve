package Problem_Solve;

import java.io.*;
import java.util.*;

public class _3651 {

    static final long MAX = 1000000000000001L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long m = Long.parseLong(br.readLine());
        br.close();
        ArrayList<String> list = new ArrayList<>(10);
        list.add(m + " " + (m-1));
        if (m != 2) {
            list.add(m + " " + 1);
        }


        long n = m;
        for (long i = 2; i <= n/2; i++) {
            long lo = 0;
            long hi = n+1;
            while (lo < hi) {
                long mid = (hi + lo) / 2;

                long res = combination(mid, i);
                if (res > m) {
                    hi = mid;
                } else if (res < m){
                    lo = mid + 1;
                } else {
                    if (i != mid - i) {
                        list.add(mid + " " + (mid - i));
                    }
                    list.add(mid + " " + i);
                    lo = mid;
                    break;
                }
            }
            n = lo;
        }

        int size = list.size();

        bw.write(size+"");
        bw.newLine();
        for (int i = size-1; i >= 0; i--) {
            bw.write(list.get(i));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static long combination(long n, long r) {
        long res = n - r + 1;

        for (long i = 2; i <= r; i++) {
            res = (res * (n - r + i)) / i;
            if (res >= MAX || res < 0) return MAX;
        }
        return res;
    }
}