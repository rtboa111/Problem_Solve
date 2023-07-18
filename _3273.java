package Problem_Solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0, j = n-1; i < j;) {
            int cur = arr[i] + arr[j];
            if (cur < x) {
                i++;
            } else if (cur > x) {
                j--;
            } else {
                cnt++;
                i++; j--;
            }
        }
        System.out.println(cnt);
    }
}