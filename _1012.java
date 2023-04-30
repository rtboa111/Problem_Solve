package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _1012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 개수
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < T; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());   // 배추밭 가로
            int N = Integer.parseInt(st.nextToken());   // 배추밭 세로
            int K = Integer.parseInt(st.nextToken());   // 배추 개수
            boolean[][] cabbage_field = new boolean[M][N];  // 배추밭
            for (int i = 0; i < K; i++) {   // 배추 심은 위치 입력
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage_field[x][y] = true;
            }
            sb.append(earthworm_to_need(cabbage_field,M,N)).append("\n");
        }
        System.out.println(sb);
    }
    static int earthworm_to_need(boolean[][] CF,int M,int N) {
        int count = 0;  // 배추벌레가 필요한 영역의 개수
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (CF[i][j]) { // 배추가 심어져 있으면 탐색 시작
                    search_cabbage_area(CF, i, j, M, N);
                    count++;
                }
            }
        }
        return count;
    }
    // 배추가 붙어있는 영역을 DFS 로 탐색하고 확인한 위치를 재탐색하지 않도록 닫음
    static void search_cabbage_area(boolean[][] CF, int x, int y, int M, int N) {
        if (!CF[x][y]) {
            return;
        }
        CF[x][y] = false;
        if (x+1 < M) {
            search_cabbage_area(CF, x + 1, y, M, N);
        }
        if (y+1 < N) {
            search_cabbage_area(CF, x, y + 1,M,N);
        }
        if (x-1 >= 0) {
            search_cabbage_area(CF, x - 1, y, M, N);
        }
        if (y-1 >= 0) {
            search_cabbage_area(CF, x, y - 1, M, N);
        }
    }
}
