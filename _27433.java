package Problem_Solve;

import java.io.*;
/*
 * 팩토리얼
 *
 * 재귀함수로 구현한 팩토리얼 함수
 */
public class _27433 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(1);
        } else {
            System.out.println(factorial(N,N));
        }
    }
    public static long factorial(long N,long X) {
        if (N == 1) {
            return X;
        }
        N--;
        return factorial(N,X*N);
    }
}

