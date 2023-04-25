package Problem_Solve;

import java.io.*;
import java.math.BigInteger;
/*
 * 하노이탑
 *
 * 재귀함수를 사용하여 풀이
 * n번째 디스크를 from 에서 to 로 옮기려면
 * n-1번째 디스크를 from 에서 other 로 옮겨야 함
 * 그 후 n-1번째 디스크를 other 에서 to 로 옮겨야 함
 */
public class _1914 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N <= 20) {
            int result = (int) Math.pow(2, N) - 1;
            sb.append(result).append("\n");
            hanoi(N, 1, 3, 2);
        } else {
            BigInteger result = new BigInteger("2");
            result = result.pow(N);
            result = result.subtract(new BigInteger("1"));
            sb.append(result);
        }
        System.out.println(sb);
    }
    public static StringBuilder sb = new StringBuilder();
    public static void hanoi(int disk, int from, int to, int other) {
        if (disk < 2) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(disk-1, from, other, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(disk-1, other, to, from);
    }
}
