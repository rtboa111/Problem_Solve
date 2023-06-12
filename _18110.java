package Problem_Solve;

import java.io.*;

public class _18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] counting = new int[31];
        for (int i = 0; i < N; i++) {
            counting[Integer.parseInt(br.readLine())]++;
        }
        int cut = (int) Math.round(N * 0.15);
        int tmp = cut;
        int idx = 1;
        while (cut != 0) {
            counting[idx] -= cut;
            cut = 0;
            if (counting[idx] < 0) {
                cut = Math.abs(counting[idx]);
                counting[idx] = 0;
                idx++;
            }
        }

        cut = tmp;
        idx = 30;
        while (cut != 0) {
            counting[idx] -= cut;
            cut = 0;
            if (counting[idx] < 0) {
                cut = Math.abs(counting[idx]);
                counting[idx] = 0;
                idx--;
            }
        }

        int res = 0;
        int num = 0;
        for (int i = 1; i <= 30; i++) {
            res += counting[i] * i;
            num += counting[i];
        }
        res = (int) Math.round(res / (double) num);
        System.out.println(res);
    }
}