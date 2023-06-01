package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        prefixSumMatrix = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                prefixSumMatrix[i][j] = prefixSumMatrix[i-1][j] + prefixSumMatrix[i][j-1] - prefixSumMatrix[i-1][j-1] + cur;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            bw.write(prefixSum(x1, y1, x2, y2)+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int[][] prefixSumMatrix;
    static int prefixSum(int x1, int y1, int x2, int y2) {
        return (prefixSumMatrix[x2][y2] - (prefixSumMatrix[x1-1][y2] +
                prefixSumMatrix[x2][y1-1] - prefixSumMatrix[x1-1][y1-1]));
    }
}