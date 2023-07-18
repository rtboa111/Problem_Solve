package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2086 {

    static final long MOD = 1000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long Sa = divideAndConquer(a+1);
        long Sb = divideAndConquer(b+2);
        System.out.println((Sb - Sa + MOD) % MOD);
    }
    static long divideAndConquer(long x) {
        long[][] res = {{1, 1}, {1, 0}};
        long[][] multiplyLater = {{1, 0}, {0, 1}};;
        while (x > 1) {

            if (x % 2 == 1) {
                multiplyLater = matrixMultiply(multiplyLater, res);
            }

            res = matrixMultiply(res, res);
            x /= 2;
        }

        res = matrixMultiply(res, multiplyLater);

        return res[1][0];
    }
    static long[][] matrixMultiply(long[][] x, long[][] y) {
        long[][] res = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    res[i][j] += (x[i][k] * y[k][j]);
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }
}
