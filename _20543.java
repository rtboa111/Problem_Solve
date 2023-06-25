package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _20543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] inha = new long[N+1][N+1];
        long[][] prefixSum = new long[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                inha[i][j] = -Long.parseLong(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                long AB = 0, ad = 0, cb = 0, cd = 0;
                if (i - (M >> 1) >= 0 && j - (M >> 1) >= 0) {
                    AB = inha[i - (M >> 1)][j - (M >> 1)];
                }
                if (i - M >= 0 && j - M >= 0) {
                    cd = prefixSum[i - M][j - M];
                }
                if (i - M >= 0) {
                    cb = prefixSum[i - M][j];
                }
                if (j - M >= 0) {
                    ad = prefixSum[i][j - M];
                }
                prefixSum[i][j] = AB + cb + ad - cd;
                bw.write((prefixSum[i][j] - prefixSum[i-1][j] - prefixSum[i][j-1] + prefixSum[i-1][j-1]) +" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}