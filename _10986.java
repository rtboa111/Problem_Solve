package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] check = new int[M]; // 나온 수 카운팅
        int prefixSum = 0;   // 구간 합
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            prefixSum = (prefixSum + cur) % M;
            check[prefixSum % M]++;
        }
        long count = check[0];
        for (long i : check) {
            if (i > 1) {
                count += (i * (i - 1)) / 2;
            }
        }
        System.out.println(count);
    }
}