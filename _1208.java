package Problem_Solve;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1208 {

    static int[] comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int a = n/2;
        comb = new int[(1<<(a+1))];
        for (int i = 0; i < (1<<(a+1)); i++) {
            for (int j = 0 ; j <= a; j++) {
                if ((i | (1<<j)) == i) {
                    comb[i] += arr[j];
                }
            }
        }
        Arrays.sort(comb);
        long cnt = 0;
        int b = n-a-1;
        for (int i = 0; i < (1<<b); i++) {
            int num = 0;
            for (int j = 0; j < b; j++) {
                if ((i | (1<<j)) == i) {
                    num += arr[j+a+1];
                }
            }
            cnt += bi(s - num);
        }
        if (s == 0) cnt--;
        System.out.println(cnt);
    }
    static int bi(int num) {
        int lo = 0, hi = comb.length;
        while (lo+1 < hi) {
            int mid = (lo + hi) / 2;
            if (comb[mid] <= num) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (comb[lo] != num) return 0;

        int ans = lo+1;
        hi = lo; lo = -1;
        while (lo+1 < hi) {
            int mid = (lo + hi) / 2;
            if (comb[mid] < num) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        ans -= hi;
        return ans;
    }
}