package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _2178 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new boolean[N][M];
        check = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (br.read() == '1') {
                    miro[i][j] = true;
                }
            }
            br.readLine();
        }
        dfs(1, 0, 0);
        System.out.println(check[N-1][M-1]);
    }
    static boolean[][] miro;
    static int[][] check;
    static int N, M;
    static void dfs(int count, int x, int y) {
        if (check[y][x] != 0 && check[y][x] <= count) {
            return;
        }

        check[y][x] = count;

        if (x == M && y == N) {
            return;
        }

        if (x+1 < M && miro[y][x+1]) {
            dfs(count+1, x+1, y);
        }
        if (y+1 < N && miro[y+1][x]) {
            dfs(count+1, x, y+1);
        }
        if (x-1 >= 0 && miro[y][x-1]) {
            dfs(count+1, x-1, y);
        }
        if (y-1 >= 0 && miro[y-1][x]) {
            dfs(count+1, x, y-1);
        }
    }
}
