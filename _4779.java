package Problem_Solve;

import java.io.*;

public class _4779 {

    static boolean[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {    //  입력이 없을 때 까지
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(str);
            int n = (int) Math.pow(3,N);
            result = new boolean[n];
            cantor_set(n,0);

            for (int i = 0; i < n; i++) {
                if (!result[i]) {
                    sb.append("-");
                } else {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }

    // 재귀로 구현한 칸토어 집합 함수
    static void cantor_set(int N,int SP) {
        if (N == 1) {
            return;
        }
        int start = (N / 3);
        int end = ((N / 3) * 2);
        for (int i = start + SP; i < end + SP; i++) {
            result[i] = true;
        }
        cantor_set(N/3, SP);
        cantor_set(N/3, end+SP);
    }
}
