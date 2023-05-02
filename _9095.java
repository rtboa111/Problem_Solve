package Problem_Solve;

import java.io.*;

public class _9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            result = 0;
            plus_123(x, 0);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    static int result;
    static void plus_123(int x, int sum) {  // 3가지 경우의 수 재귀로 구현
        if (sum == x) { // 목표에 도달하면 카운트 후 종료
            result++;
            return;
        } else if (sum > x) {   // 목표 수를 넘으면 카운트 없이 종료
            return;
        }
        plus_123(x, sum + 1);
        plus_123(x, sum + 2);
        plus_123(x, sum + 3);
    }
}