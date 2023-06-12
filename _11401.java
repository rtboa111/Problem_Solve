package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

/*
 * 페르마의 소정리 : a^(p-1) % p == 1 (a < p && a와 p는 서로소)
 * 이를 양번에 a^(-1)를 곱하면 : a^(p-2) % p == a^(-1)
 *
 * 이항계수 (n, r)은 nCr == n!/k!(n-k)! 이고 n! 을 A, k!(n-k)! 을 B라고 하면
 * A*B^(-1) 로 둘 수 있고 문제에서 소수인 p로 나눈 나머지를 구하라고 하였으므로
 * (A%p)*(B^(-1)%p) 로 나타낼 수 있고 뒷 부분은 위에 정리한 페르마의 소정리 꼴이므로
 * B^(-1) == B^(p-2)%p 로 표현이 가능함
 */
public class _11401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long res = combination(N, K);

        System.out.println(res);
    }
    static final int NUM = 1000000007;
    static long combination(long N, long K) {
        long A = 1;  // N!
        long B = 1;  // K!*(N-K)!
        for (long i = N; i >= 2; i--) {
            A = (A * i) % NUM;
        }
        for (long i = K; i >= 2; i--) {
            B = (B * i) % NUM;
        }
        for (long i = N - K; i >= 2; i--) {
            B = (B * i) % NUM;
        }

        A = (A * power(B)) % NUM;
        return A;
    }

    // B^(NUM-2) % NUM
    static long power(long B) {
        long num = NUM - 2;
        long add = 1;
        while (num > 1) {
            if (num % 2 == 1) {
                add = (add * B) % NUM;
            }
            B = (B * B) % NUM;
            num = (num >> 1);
        }
        B = (B * add) % NUM;
        return B;
    }
}