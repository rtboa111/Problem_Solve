package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
/*
 * {{1, 1},{1, 0}} * {{fn}, {fn-1}} = {{fn+1}, {fn}}
 * {{1, 1},{1, 0}}^a * {{f1}, {f0}} = {{fa+1}, {fa}}
 */
public class _11444 {

    static final long mod = 1000000007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        long[][] procession = new long[][]{{1, 1}, {1, 0}};   // {{fn+1, fn},{fn, fn-1}}

        ArrayList<long[][]> multiplyLater = new ArrayList<>();

        while (N > 1L) {

            if (N % 2 == 1) {
                multiplyLater.add(procession.clone());
            }

            long[][] tmp = new long[2][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        tmp[i][j] = (tmp[i][j] + procession[i][k] * procession[k][j]) % mod;
                    }
                }
            }

            procession = tmp.clone();

            N = (N >> 1);
        }


        for (long[][] multiply : multiplyLater) {

            long[][] tmp = new long[2][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        tmp[i][j] = (tmp[i][j] + multiply[i][k] * procession[k][j]) % mod;
                    }
                }
            }

            procession = tmp.clone();
        }

        bw.write(procession[0][1] + "");
        bw.flush();
        bw.close();
    }
}