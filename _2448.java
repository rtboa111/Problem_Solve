package Problem_Solve;

import java.io.*;

public class _2448 {

    static int N;
    static char[][] stars =
            {{' ', ' ', '*', ' ', ' ', ' '} ,
             {' ', '*', ' ', '*', ' ', ' '} ,
             {'*', '*', '*', '*', '*', ' '}};

    static char[][] ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        ans = new char[N][N*2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N << 1; j++) {
                ans[i][j] = ' ';
            }
        }
        divide(0, 0, N);

        for (char[] s : ans) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void divide(int x, int y, int cur) {
        if (cur == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 6; j++) {
                    ans[x+i][y+j] = stars[i][j];
                }
            }
            return;
        }

        int size = cur / 2;

        divide(x, y + size, size);
        divide(x + size, y, size);
        divide(x + size, y + size*2, size);
    }
}