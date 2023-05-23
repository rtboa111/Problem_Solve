package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1107 {

    static int result;
    static int N;
    static boolean[] isBroken = new boolean[10];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                isBroken[Integer.parseInt(st.nextToken())] = true;  // 고장난버튼
            }
        }

        result = Math.abs(N - 100); // +-만 누르기

        push(0, 1);

        System.out.println(result);
    }
    static void push(int n, int dig) {
        if (String.valueOf(dig).length() > 6) {
            return;
        }
        for (int j = 0; j <= 9; j++) {
            if (!isBroken[j]) {
                int tmp = n + (j * dig);
                push(tmp , dig * 10);
                result = Math.min(Math.abs(N - tmp) + String.valueOf(tmp).length(), result);
            }
        }
    }
}