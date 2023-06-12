package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _10830 {

    static final int mod = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[][]> addLetter = new ArrayList<>();

        while (B > 1L) {
            int[][] res = new int[N][N];

            if (B % 2 == 1) {
                addLetter.add(A.clone());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        res[i][j] = (res[i][j] + (A[i][k] * A[k][j])) % mod;
                    }
                }
            }

            A = res.clone();

            B = (B >> 1);
        }

        for (int[][] add : addLetter) {

            int[][] res = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        res[i][j] = (res[i][j] + (A[i][k] * add[k][j])) % mod;
                    }
                }
            }

            A = res.clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] %= mod;
                bw.write(A[i][j]+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}