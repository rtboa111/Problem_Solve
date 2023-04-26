package Problem_Solve;

import java.io.*;
/*
 * 피보나치 수열
 *
 * 재귀함수로 구현한 피보나치 수열
 */
public class _10870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(N, 2, 0, 1 ));
    }
    public static int fibonacci(int N, int I, int A, int B) {
        if (N == 0) {
            return A;
        } else if (N == 1) {
            return B;
        } else if (I > N) {
            return A + B;
        }
        return fibonacci(N, ++I, A + B, A);
    }
}
