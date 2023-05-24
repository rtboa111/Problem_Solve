package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1780 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken())+1;
            }
        }

        count = new int[3];
        cut(N, 0, 0);

        for (int i : count) {
            System.out.println(i);
        }

    }
    static int[][] paper;
    static int N;
    static int[] count;
    static void cut(int num, int x, int y) {
        if (same_check(num, x, y)) {    // 같은 구성이 아니면 더 잘게 자름
            count[paper[x][y]]++;
            return;
        }
        if (num == 1) {
            return;
        }

        int size = num / 3;

        for (int i = x ; i < x + num; i+=size) {
            for (int j = y ; j < y + num; j+=size) {

                cut(size, i, j);
            }
        }

    }

    // 구성이 같은지 확인
    static boolean same_check(int size, int x, int y) {
        int type = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j ++) {
                if (paper[i][j] != type) {
                    return false;
                }
            }
        }
        return true;
    }
}