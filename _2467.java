package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[3];
        ans[2] = Integer.MAX_VALUE;
        for (int i = 0, j = n-1; i < j;) {
            int cur = arr[i] + arr[j];
            if (Math.abs(ans[2]) > Math.abs(cur)) {
                ans[0] = arr[i]; ans[1] = arr[j]; ans[2] = cur;
            }
            if (cur > 0) {
                j--;
            } else if (cur < 0) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
