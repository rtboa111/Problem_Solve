package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1799 {

    static int N, count;
    static boolean[] board, LDiagonalCan, RDiagonalCan;
    static ArrayList<LinkedList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N*N];   // 체스판 - true 는 놓을 수 없는 곳
        LDiagonalCan = new boolean[N*2-1]; // 가능한 왼쪽 대각선 - 왼쪽 위부터 x + y
        RDiagonalCan = new boolean[N*2-1]; // 가능한 오른쪽 대각선 - 왼쪽 아래부터 N - 1 - x + y
        count = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) {    // 둘 수 없는 구간
                    board[i*N+j] = true;
                }
            }
        }
        for (int i = 0; i < N*2-1; i++) {
            LinkedList<Integer> cur = new LinkedList<>();
            list.add(cur);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!board[i*N+j]) {
                    LDiagonalCan[i+j] = true;
                    RDiagonalCan[N-1-i+j] = true;
                    list.get(i+j).add(i*N+j);   // 왼쪽 대각선에 대해 있는 두는게 가능한 칸 추가
                }
            }
        }

        dfs(0, 0);

        System.out.println(count);
    }

    /*
     * 대각선 한 줄당 비숍을 하나씩 두어야 함
     */
    static void dfs(int cnt, int idx) {

        if (idx >= N*2-1) {
            count = Math.max(count, cnt);
            return;
        }

        if (!LDiagonalCan[idx]) {
            dfs(cnt, idx+1);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i : list.get(idx)) {
            int x = i / N;
            int y = i - (x * N);
            if (!board[i] && RDiagonalCan[N-1-x+y]) {   // 두는게 가능한 위치만 추가
                q.add(i);
            }
        }

        if (q.isEmpty()) {
            dfs(cnt, idx+1);
        } else {
            while (!q.isEmpty()) {
                int cur = q.remove();
                int x = cur / N;
                int y = cur - (x * N);

                board[cur] = true;
                LDiagonalCan[idx] = false;
                RDiagonalCan[N-1-x+y] = false;

                dfs(cnt+1, idx+1);

                board[cur] = false;
                LDiagonalCan[idx] = true;
                RDiagonalCan[N-1-x+y] = true;
            }
        }
    }
}