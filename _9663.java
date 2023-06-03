package Problem_Solve;

import java.io.*;

public class _9663 {

    static int N, count;
    static boolean[] board, xCan, yCan, LDiagonalCan, RDiagonalCan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        board = new boolean[N*N];   // 체스판
        xCan = new boolean[N];  // 가능한 x축
        yCan = new boolean[N];  // 가능한 y축
        LDiagonalCan = new boolean[N*2]; // 가능한 왼쪽 대각선 - 왼쪽 위부터 x + y
        RDiagonalCan = new boolean[N*2]; // 가능한 오른쪽 대각선 - 왼쪽 아래부터 N - 1 - x + y

        for (int i = 0; i < N; i++) {
            xCan[i] = true;
            yCan[i] = true;
            LDiagonalCan[i] = true;
            RDiagonalCan[i] = true;
            LDiagonalCan[i+N] = true;
            RDiagonalCan[i+N] = true;
        }

        count = 0;

        dfs(0, 0);

        if (N == 1) {
            count = 1;
        }

        System.out.println(count);
    }
    static void dfs(int cnt, int idx) {
        if (cnt == N) {
            count++;
            return;
        }

        int x = idx / N;
        int y = idx - (x * N);

        while (idx < N*N && (!yCan[y] || !LDiagonalCan[x+y] || !RDiagonalCan[N-1-x+y])) {
            idx++;
            x = idx / N;
            y = idx - (x * N);
        }

        for (int i = x-1; i >= 0; i--) {
            if (xCan[i]) return;
        }

        if (idx >= N * N) {
            return;
        }

        board[idx] = true;
        xCan[x] = false;
        yCan[y] = false;
        LDiagonalCan[x + y] = false;
        RDiagonalCan[N - 1 - x + y] = false;

        dfs(cnt + 1, idx + N - y);

        board[idx] = false;
        xCan[x] = true;
        yCan[y] = true;
        LDiagonalCan[x + y] = true;
        RDiagonalCan[N - 1 - x + y] = true;

        dfs(cnt, idx + 1);
    }
}