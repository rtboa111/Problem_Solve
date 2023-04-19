package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long a = 0;
        int[] k = new int[K];
        for (int i = 0; i < K; i++) {
            k[i] = Integer.parseInt(br.readLine());
            a += k[i];
        }
        a /= N;
        long min = 0;
        long max = a*2+1;
        while (min < max) {
            long mid = (min/2) + (max/2);
            int count = 0;
            for (int i = 0; i < K; i++) {
                count += k[i]/mid;
            }
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
