package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
/*
 * 주어진 범위 내의 소수 구하기
 *
 * 작은 소수의 곱부터 지워나가는
 * 에라토스테네스의 체를
 * 재귀함수로 구현해 소수를 찾음
 */
public class _1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] sifter = new boolean[N+1];
        sifter[1] = true;
        sifter(sifter, 2,(int) Math.sqrt(N));
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!sifter[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
    static void sifter(boolean[] si, int start, int maximum) {
        if (start > maximum) {
            return;
        }
        for (int i = start*start; i <= si.length-1; i+=start) {
            si[i] = true;
        }
        start++;
        while (si[start]) {
            start++;
        }
        sifter(si, start, maximum);
    }
}
