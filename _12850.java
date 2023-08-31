package Problem_Solve;

import java.io.*;

public class _12850 {

    static int MOD = (int) (1e9 + 7);
    static long[][] vector = {
            {0, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 1, 0, 0},
            {0, 0, 1, 1, 0, 1, 0, 1},
            {0, 0, 0, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        long[][] res = new long[8][8];
        for (int i = 0; i < 8; i++) {
            res[i][i] = 1;
        }

        while (D > 1) {
            if (D % 2 == 1) {
                res = multiply(res, vector);
            }
            vector = multiply(vector, vector);
            D >>= 1;
        }
        res = multiply(res, vector);
        System.out.println(res[0][0]);
    }
    static long[][] multiply(long[][] A, long[][] B) {
        long[][] ans = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                long num = 0;
                for (int k = 0; k < 8; k++) {
                    num += (A[i][k] * B[k][j]);
                    num %= MOD;
                }
                ans[i][j] = num;
            }
        }
        return ans;
    }
}