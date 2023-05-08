package Problem_Solve;

import java.io.*;
import java.math.BigInteger;

public class _11726 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tail_a = n; // 2*1 타일
        int tail_b = 0; // 1*2 타일 2개씩 묶음으로 사용
        int sum, max;
        int count = 0;
        while(tail_a >= 0) {
            sum = tail_a + tail_b;
            max = Math.max(tail_a, tail_b);
            count += choice(sum, max);
            count %= 10007;
            tail_a -= 2;
            tail_b++;
        }
        System.out.println(count);
    }
    static double choice(int sum, int max) {    // nCr (n == sum, r == max)
        int min = sum - max;
        if (min == 0) { // nC0 == 1
            return 1;
        }
        BigInteger result = new BigInteger(String.valueOf(1));
        for (int i = sum; i > max; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        for (int i = min; i > 1; i--) {
            result = result.divide(BigInteger.valueOf(i));
        }
        result = result.mod(BigInteger.valueOf(10007));
        return result.doubleValue();
    }
}