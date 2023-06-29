package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] max1 = {board[0][0], 0}, max2 = {board[0][1], 0}, max3 = {board[0][2], 0};
        int[] min1 = {board[0][0], 0}, min2 = {board[0][1], 0}, min3 = {board[0][2], 0};
        for (int i = 1; i < N; i++) {
            max1[1] = board[i][0] + Math.max(max1[0], max2[0]);
            max2[1] = board[i][1] + Math.max(max1[0], Math.max(max2[0], max3[0]));
            max3[1] = board[i][2] + Math.max(max2[0], max3[0]);

            max1[0] = max1[1]; max2[0] = max2[1]; max3[0] = max3[1];

            min1[1] = board[i][0] + Math.min(min1[0], min2[0]);
            min2[1] = board[i][1] + Math.min(min1[0], Math.min(min2[0], min3[0]));
            min3[1] = board[i][2] + Math.min(min2[0], min3[0]);

            min1[0] = min1[1]; min2[0] = min2[1]; min3[0] = min3[1];
        }
        System.out.print(Math.max(max1[0], Math.max(max2[0], max3[0])) + " " + Math.min(min1[0], Math.min(min2[0], min3[0])));
    }
}