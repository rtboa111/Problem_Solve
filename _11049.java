package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _11049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] procession = new int[N+1][2];
        int[][] dp = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            procession[i][0] = r;
            procession[i][1] = c;
        }

        for (int i = 1; i <= N; i++) {  // 나누는 단위
            for (int j = 1; j + i <= N; j++) {  // 시작점
                int end = j + i;    // 끝점

                dp[j][end] = Integer.MAX_VALUE;
                for (int div = j; div < end; div++) {   // 나눠지는 부분
                    // 나뉘는 부분의 후반부 r이 곱하게 되는 중간 r 이기 때문에 [end][0] 이 아니라 [div+1][0] 사용함
                    dp[j][end] = Math.min(dp[j][end], dp[j][div] + dp[div+1][end]
                            + (procession[j][0] * procession[div+1][0] * procession[end][1]));
                }
            }
        }
        System.out.println(dp[1][N]);
    }
}