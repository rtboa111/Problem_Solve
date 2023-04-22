package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
/*
 * 마인크래프트 바닥 고르게하기
 *
 * 고르게 할 수 있는 바닥 높이의 최소 최대를 구하고
 * 평탄화 후 종료함
 */
public class _18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                A[i][j] = value;
                B += value;
                lo = Math.min(lo, value);
                hi = Math.max(hi, value);
            }
        }
        hi = Math.min(B/(N*M),hi);
        int loo = 0;
        int time = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            int a = Search(i,A);
            if (time >= a) {
                time = a;
                loo = i;
            }
        }
        sb.append(time).append(" ").append(loo);
        System.out.println(sb);
    }

    public static int Search(int section, int[][] A) {
        int time = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                int a = section - A[i][j];
                if (a > 0) {
                    time += a;
                } else if (a < 0){
                    time -= (a * 2);
                }
            }
        }
        return time;
    }
}