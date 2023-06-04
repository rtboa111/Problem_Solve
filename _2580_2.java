package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _2580_2 {

    static int[] board = new int[9*9];
    static boolean[] cCheck = new boolean[9*9];
    static boolean[] rCheck = new boolean[9*9];
    static boolean[] squareCheck = new boolean[9*9];
    static boolean end = false;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int cur = Integer.parseInt(st.nextToken());
                board[i*9+j] = cur;
                if (cur != 0) {
                    int x = i / 3;
                    int y = j / 3;
                    cCheck[i*9+cur-1] = true;
                    rCheck[j*9+cur-1] = true;
                    squareCheck[(x*3+y)*9+cur-1] = true;
                }
            }
        }

        backtracking(0);

        bw.flush();
        bw.close();

    }

    static void backtracking(int idx) throws IOException {
        if (end) return;
        if (idx == 81) {
            end = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(board[i*9+j] + " ");
                }
                bw.newLine();
            }
            return;
        }
        if (board[idx] != 0) {

            backtracking(idx+1);

        } else {

            int i = idx / 9;
            int j = idx % 9;
            int x = i / 3;
            int y = j / 3;
            int tmp = (x * 3 + y) * 9;

            for (int k = 0; k < 9; k++) {

                if (!cCheck[i*9+k] && !rCheck[j*9+k] &&!squareCheck[tmp+k]) {

                    board[idx] = k+1;
                    cCheck[i*9+k] = true;
                    rCheck[j*9+k] = true;
                    squareCheck[tmp+k] = true;

                    backtracking(idx + 1);

                    board[idx] = 0;
                    cCheck[i*9+k] = false;
                    rCheck[j*9+k] = false;
                    squareCheck[tmp+k] = false;
                }
            }
        }
    }
}