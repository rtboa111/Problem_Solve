package Problem_Solve;

import java.io.*;
import java.util.ArrayList;

public class _9326 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int code = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = new ArrayList<>(32);
            for (int j = 2; j * j <= code; j++) {
                int n = 0;
                while (code % j == 0) {
                    n++;
                    code /= j;
                }
                if (n == 0) continue;

                int num = 1 << 30;
                while (num > 0) {
                    if (n >= num) {
                        res.add((int) Math.pow(j, num));
                        n -= num;
                    }
                    num >>= 1;
                }
            }
            if (code > 1) {
                res.add(code);
            }
            res.sort(Integer::compare);

            for (int j : res) {
                bw.write(j + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}