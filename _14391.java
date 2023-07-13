package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

// https://code-lab1.tistory.com/101 참조
public class _14391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] paper = new char[N][M];
        for (int i = 0; i < N; i++) {
            paper[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                paper[i][j] -= '0';
            }
        }

        int res = 0;
        for (int i = 0; i < (1 << N * M); i++) {

            int sum = 0;
            // 가로
            for (int j = 0; j < N; j++) {
                int cur = 0;
                for (int k = 0; k < M; k++) {
                    if ((i & (1 << j * M + k)) == 0) {
                        cur *= 10;  // 연속되어 있으면 자릿수 올림
                        cur += paper[j][k];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            // 세로
            for (int j = 0; j < M; j++) {
                int cur = 0;
                for (int k = 0; k < N; k++) {
                    if ((i & (1 << k * M + j)) != 0) {
                        cur *= 10;
                        cur += paper[k][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}