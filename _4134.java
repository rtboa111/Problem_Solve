package Problem_Solve;

import java.io.*;

public class _4134 {

    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Long.parseLong(br.readLine());
            if (n < 2) {
                bw.write("2");
            } else {
                prime_check(false);
                bw.write(n + "");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    // 에라토스테네스의 체 응용
    static void prime_check(boolean find) {
        if (find) {
            return;
        }

        int n_root = (int) Math.pow(n, 0.5);

        for (int i = 2; i <= n_root; i++) {
            if (n % i == 0) {// 나누어지면 소수가 아님
                n++;
                prime_check(find);
                return;
            }
        }
        prime_check(true);
    }
}
