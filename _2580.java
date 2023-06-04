package Problem_Solve;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2580 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] board = new int[81];
    static boolean end = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int cur = Integer.parseInt(st.nextToken());
                board[i*9+j] = cur;
                if (cur == 0) {
                    cnt++;
                }
            }
        }

        backtracking(cnt);

        bw.flush();
        bw.close();

    }

    static void backtracking(int cnt) throws IOException {
        if (end) return;
        if (cnt == 0) {
            end = true;
            bw.write(board[0]+" ");
            for (int i = 1; i < 81; i++) {
                if (i % 9 == 0) {
                    bw.newLine();
                }
                bw.write(board[i]+" ");
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i*9+j] == 0) {
                    Queue<Integer> q = list(i, j);
                    while (!q.isEmpty()) {
                        int cur = q.remove();
                        board[i*9+j] = cur;
                        backtracking(cnt-1);
                        board[i*9+j] = 0;
                    }
                    if (board[i*9+j] == 0) {
                        return;
                    }
                }
            }
        }
    }
    static Queue<Integer> list(int c, int r) {
        Queue<Integer> res = new LinkedList<>();
        boolean[] Check = new boolean[10];
        int x = (c / 3) * 3;
        int y = (r / 3) * 3;
        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; j++) {
                Check[board[i*9+j]] = true;
            }
        }
        for (int i = 0; i < 9; i++) {
            Check[board[i*9+r]] = true;
            Check[board[c*9+i]] = true;
        }
        for (int i = 1; i <= 9; i++) {
            if (!Check[i]) {
                res.add(i);
            }
        }
        return res;
    }
}