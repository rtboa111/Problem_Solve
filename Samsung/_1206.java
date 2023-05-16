package Problem_Solve.Samsung;

import java.io.*;
import java.util.StringTokenizer;

public class _1206 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N;
        int[] apart;
        for (int i = 1; i <= 10; i++) {
            N = Integer.parseInt(br.readLine());
            apart = new int[N];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                apart[j] = Integer.parseInt(st.nextToken());
            }
            secure(apart, 2);
            bw.write("#" + i + " " + count);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int count;
    static void secure(int[] apart, int idx) {

        int hi, block;

        while (idx < apart.length-2) {
            hi = apart[idx];
            block = 0;
            for (int i = -2, j = 1; i < 0; i++, j++) {
                block = Math.max(apart[idx + i], block);
                block = Math.max(apart[idx + j], block);
            }

            hi -= block;
            if (hi > 0) {
                count += hi;
            }
            idx++;
        }
    }
}
