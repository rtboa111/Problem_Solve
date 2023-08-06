package Problem_Solve.Arena.GrandArena_1;

import java.io.*;
import java.util.StringTokenizer;

public class H {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] board = new int[n+1][m+1];
        int[] row = new int[n+1];
        int[] col = new int[m+1];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (dir == 1) {
                row[line] += num;
            } else {
                col[line] += num;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)  {
                board[i][j] = row[i] + col[j];
                board[i][j] += board[i-1][j] + board[i][j-1] - board[i-1][j-1];
                bw.write(board[i][j] - board[i-1][j] - board[i][j-1] + board[i-1][j-1] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

