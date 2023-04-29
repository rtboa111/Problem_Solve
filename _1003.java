package Problem_Solve;

import java.io.*;
/*
 * 피보나치 수열을 재귀함수로 구현했을 때 fibonacci(n)에 대한
 * fibonacci(0)와 fibonacci(1)의 호출 횟수
 *
 * 배열을 만들고 0과 1의 피보나치 호출 횟수를 입력한 뒤
 * n 이 될 수 있는 최댓값까지의 피보나치 호출 횟수를
 * 배열에 입력하고 각 n에 대한 호출 횟수를 출력한다.
 */
public class _1003 {

    static int[] arrZ = new int[41];
    static int[] arrO = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arrZ[0] = 1;
        arrO[0] = 0;
        arrZ[1] = 0;
        arrO[1] = 1;
        int[] N = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            N[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, N[i]);
        }
        for (int j = 2; j <= max; j++) {
            fibonacci_count(j);
        }
        for (int n : N) {
            sb.append(arrZ[n]).append(" ").append(arrO[n]).append("\n");
        }
        System.out.println(sb);
    }
    static int zero = 0;
    static int one = 0;
    static void fibonacci_count(int n) {
        arrZ[n] += arrZ[n-1];
        arrO[n] += arrO[n-1];
        arrZ[n] += arrZ[n-2];
        arrO[n] += arrO[n-2];
    }
}
