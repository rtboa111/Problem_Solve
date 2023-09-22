package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2473 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long[] res = {1L << 32, -1, -1, -1};
        for (int i = 0; i < n-2; i++) {
            int s = i+1, e = n-1;
            long ans = arr[i];
            while (s < e) {
                long tmp = arr[s] + arr[e];
                if (Math.abs(res[0]) > Math.abs(tmp+ans)) {
                    res[0] = ans + tmp;
                    res[1] = i; res[2] = s; res[3] = e;
                }
                if (ans + tmp < 0) {
                    s++;
                } else if (ans + tmp > 0){
                    e--;
                } else {
                    s++; e--;
                }
            }
        }
        for (int i = 1; i <= 3; i++) System.out.print(arr[(int) res[i]] + " ");
    }
}