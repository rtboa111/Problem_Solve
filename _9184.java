package Problem_Solve;

import java.io.*;
import java.util.*;

public class _9184 {

    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 1;
                    }
                }
            }
        }
        w(20, 20, 20);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while (a != -1 || b != -1 || c != -1) {
            bw.write("w("+a+", "+b+", "+c+") = ");
            bw.write(w(a, b, c)+"");
            bw.newLine();

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        bw.flush();
        bw.close();
    }
    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20];
        }

        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        }

        return dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) -w(a-1,b-1,c-1);
    }
}