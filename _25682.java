package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _25682 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] prefixEven = new int[N+1][M+1];   // (x + y) % 2 == 0
        int[][] prefixOdd = new int[N+1][M+1];    // (x + y) % 2 == 1

        int col;
        for (int i = 1; i <= N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                if (line[j-1] == 'B') {
                    col = 1;
                } else {
                    col = 0;
                }
                if ((i + j) % 2 == 0) {
                    prefixEven[i][j] = col;
                } else {
                    prefixOdd[i][j] = col;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixEven[i][j] += prefixEven[i][j-1] + prefixEven[i-1][j] - prefixEven[i-1][j-1];
                prefixOdd[i][j] += prefixOdd[i][j-1] + prefixOdd[i-1][j] - prefixOdd[i-1][j-1];
            }
        }

        // 짝수위치 총 블럭
        int numE = ((K * K) / 2) + (K % 2); // K 가 홀수면 + 1
        // 홀수위치 총 블럭
        int numO = ((K * K) / 2);

        int min = Integer.MAX_VALUE;
        int even, odd;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                if ((i + j) % 2 == 0) {
                    even = prefixEven[i][j] - (prefixEven[i-K][j] + prefixEven[i][j-K] - prefixEven[i-K][j-K]);
                    odd = prefixOdd[i][j] - (prefixOdd[i-K][j] + prefixOdd[i][j-K] - prefixOdd[i-K][j-K]);
                } else {
                    even = prefixOdd[i][j] - (prefixOdd[i-K][j] + prefixOdd[i][j-K] - prefixOdd[i-K][j-K]);
                    odd = prefixEven[i][j] - (prefixEven[i-K][j] + prefixEven[i][j-K] - prefixEven[i-K][j-K]);
                }

                int cur = Math.min((numE - even) + odd, (numO - odd) + even);

                min = Math.min(min, cur);
            }
        }

        System.out.println(min);
    }
}