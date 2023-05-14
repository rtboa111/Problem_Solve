package Problem_Solve;

import java.io.*;

public class _4948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {

            bw.write(prime_check(n, 0) + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int prime_check(int n, int count) {

        for (int i = n + 1; i <= n << 1; i++) {

            boolean find = true;
            int n_root = (int) Math.pow(i, 0.5);

            for (int j = 2; j <= n_root; j++) {
                if (i % j == 0) {   // 나누어지면 소수가 아님
                    find = false;
                    break;
                }
            }
            if (find) {
                count++;
            }
        }
        return count;
    }
}