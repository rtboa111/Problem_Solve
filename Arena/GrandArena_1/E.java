package Problem_Solve.Arena.GrandArena_1;

import java.io.*;
import java.util.StringTokenizer;

public class E {

    static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[cur % k]++;
        }

        long res = arr[0] + 1;
        for (int i = 1; i < (k+1)/2; i++) {
            res = res * (power(arr[i]) + power(arr[k - i]) - 1) % MOD;
        }
        if (k % 2 == 0) {
            res = res * (arr[k/2] + 1) % MOD;
        }
        System.out.println((res + MOD - (n+1)) % MOD);
    }
    static long power(int num) {
        if (num == 0) {
            return 1;
        }
        long ans = 2;
        long remain = 1;
        while (num > 1) {
            if (num % 2 == 1) {
                remain = remain * ans % MOD;
            }
            ans = ans * ans % MOD;
            num >>= 1;
        }
        return ans * remain % MOD;
    }
}