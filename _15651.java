package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _15651 {

    static int N, M;
    static boolean[] check;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N];

        arr(0, new int[M]);

        bw.flush();
        bw.close();
    }


    static void arr(int idx, int[] result) throws IOException {
        if (idx == M) {
            print(result);
            return;
        }

        for (int i = 0; i < N; i++) {

            result[idx] = i+1;

            arr(idx+1, result);

            result[idx] = 0;
        }
    }
    static void print(int[] result) throws IOException {
        for (int i : result) {
            bw.write(i+" ");
        }
        bw.newLine();
    }
}