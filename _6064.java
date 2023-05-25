package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _6064 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int M, N, x, y, small, big, s, b;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int diff = M - N;
            if (diff == 0) {
                if (x == y) {
                    System.out.println(x);
                } else {
                    System.out.println(-1);
                }
                continue;
            } else if (diff < 0) {
                big = N;
                small = M;
                b = y;
                s = x;
            } else {
                big = M;
                small = N;
                b = x;
                s = y;
            }
            diff = Math.abs(diff);
            int time = 0;
            int B = s;
            boolean[] check = new boolean[big+1];
            while (!check[B] && !check[b]) {
                check[B] = true;
                B -= diff;
                if (B <= 0) {
                    B += big;
                }
                time++;
            }
            if (check[b]) {
                time = (small * (time - 1)) + s;
                System.out.println(time);
            } else {
                System.out.println(-1);
            }
        }
    }
}