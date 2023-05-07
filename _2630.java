package Problem_Solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {

    static boolean[][] confetti;
    static int count_b,count_w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        confetti = new boolean[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().charAt(0)=='0') {
                    confetti[i][j] = true;
                }
            }
        }
        count_b = count_w = 0;
        cut(N,0,0);
        System.out.println(count_w);
        System.out.println(count_b);
    }

    static void cut(int size, int x, int y) {
        if (possible(size, x, y)) {
            if (confetti[y][x]) {
                count_w++;
            } else {
                count_b++;
            }
        }
        else {
            int new_size = size >> 1;
            cut(new_size, x, y);
            cut(new_size, x + new_size, y);
            cut(new_size, x, y + new_size);
            cut(new_size, x + new_size, y + new_size);
        }
    }
    static boolean possible(int size, int x, int y) {
        boolean val = confetti[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (val != confetti[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}