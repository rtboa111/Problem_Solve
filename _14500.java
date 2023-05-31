package Problem_Solve;

import java.io.*;
import java.util.*;

public class _14500 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N+1][M+1];
        prefixSumPaper = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int cur = Integer.parseInt(st.nextToken());
                paper[i][j] = cur;
                prefixSumPaper[i][j] = prefixSumPaper[i-1][j] + prefixSumPaper[i][j-1] - prefixSumPaper[i-1][j-1] + cur;
            }
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 2x6 블럭
                int tmp = prefixSumMatrix(i, j, i+1, j+2);
                if (tmp != 0) {
                    // 폴리오미노 조건을 만족시키면서 값이 최소인 블럭부분을 제외
                    int a = paper[i][j];
                    a += Math.min(paper[i][j+1], Math.min(paper[i][j+2], Math.min(paper[i+1][j], paper[i+1][j+2])));
                    int b = paper[i][j+1] + paper[i][j+2];
                    int c = paper[i][j+2] + paper[i+1][j];
                    int d = paper[i+1][j];
                    d += Math.min(paper[i+1][j+1], paper[i+1][j+2]);
                    int e = paper[i+1][j+1] + paper[i+1][j+2];
                    tmp -= Math.min(a, Math.min(b, Math.min(c, Math.min(d, e))));
                    max = Math.max(max, tmp);
                }

                // 6x2 블럭
                tmp = prefixSumMatrix(i, j, i+2, j+1);
                if (tmp != 0) {
                    int a = paper[i][j];
                    a += Math.min(paper[i+1][j], Math.min(paper[i+2][j], paper[i+2][j+1]));
                    int b = paper[i+1][j] + paper[i+2][j];
                    int d = paper[i][j+1];
                    d += Math.min(paper[i+1][j+1], Math.min(paper[i+2][j], paper[i+2][j+1]));
                    int e = paper[i+1][j+1] + paper[i+2][j+1];
                    tmp -= Math.min(a, Math.min(b, Math.min(d, e)));
                    max = Math.max(max, tmp);
                }

                // 1x4 블럭
                tmp = prefixSumMatrix(i, j, i, j+3);
                if (tmp != 0) {
                    max = Math.max(max, tmp);
                }
                // 4x1 블럭
                tmp = prefixSumMatrix(i, j, i+3, j);
                if (tmp != 0) {
                    max = Math.max(max, tmp);
                }
            }
        }
        System.out.println(max);
    }
    static int N, M;
    static int[][] prefixSumPaper;
    static int[][] paper;

    static int prefixSumMatrix(int x1, int y1, int x2, int y2) {
        if (x2 > N || y2 > M) {
            return 0;
        }
        int result = prefixSumPaper[x2][y2] - (prefixSumPaper[x2][y1-1] + prefixSumPaper[x1-1][y2] - prefixSumPaper[x1-1][y1-1]);
        return result;
    }
}