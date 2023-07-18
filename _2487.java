package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _2487 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = new int[n+1];
        res[0] = 1;
        for (int i = 1; i <= n; i++) {
            int cur = arr[i];
            res[i] = (cur == i) ? 0 : 1;
            while (arr[cur] != i) {
                cur = arr[cur];
                res[i]++;
            }
            res[i]++;
            res[i] = res[i] / gcd(res[i-1], res[i]) * res[i-1];
        }
        System.out.println(res[n]);
    }
    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}