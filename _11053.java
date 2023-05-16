package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _11053 {

    static int[] check; // DP
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        check = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            sub_set(arr, i);
        }

        int result = check[0];

        for (int i = 1; i < N; i++) {
            result = Math.max(result, check[i]);
        }

        System.out.println(result);
    }

    static int sub_set(int[] arr, int n) {  // LIS

        if (check[n] == 0) {
            check[n] = 1;

            for (int i = n-1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    check[n] = Math.max(check[n], sub_set(arr, i) + 1);
                }
            }
        }
        return check[n];
    }
}