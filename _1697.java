package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N >= K) {   // N 이 더 크면 빼주기만
            int result = N - K;
            System.out.println(result);
        } else {
            hide_and_seek(N, K, 0);
            int result = (check[N] == 0) ? Integer.MAX_VALUE : check[N];
            // N 보다 밑을 탐색한 경우에 대하여
            for (int i = 0; i < N; i++) {
                if (check[i] != 0) {
                    result = Math.min(check[i] + (N-i), result);
                }
            }
            // N 보다 위를 탐색한 경우에 대하여
            for (int i = N + 1; i < Math.min(N<<1, check.length); i++) {
                if (check[i] != 0) {
                    result = Math.min(check[i] + (i-N), result);
                }
            }
            System.out.println(result);
        }
    }

    static int[] check = new int[100001];

    static void hide_and_seek(int N, int K, int count) {
        // 해당 값이 첫 탐색이 아니면서 이전 탐색의 count 보다 큰 경우 종료
        if (check[K] != 0 && check[K] <= count) {
            return;
        } else {
            check[K] = count;

            if (N == K) {
                return;
            }
        }

        if (K % 2 != 0) {
            hide_and_seek(N, K+1, count+1);
            hide_and_seek(N, K-1, count+1);
        } else {
            hide_and_seek(N, K >> 1, count+1);
        }
    }
}