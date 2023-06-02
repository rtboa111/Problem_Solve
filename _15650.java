package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _15650 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] check;
    static int[] result;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N];
        result = new int[M];

        arr(result, 0);

        bw.flush();
        bw.close();
    }

    static void arr(int[] result, int idx) throws IOException {
        if (idx == M) {
            print(result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i] && result[Math.max(idx-1, 0)] < i+1) {
                result[idx] = i+1;
                check[i]= true;
                arr(result, idx+1);
                check[i] = false;
            }
        }

    }
    static void print(int[] result) throws IOException {
        for (int i : result) {
            bw.write(i+" ");
        }
        bw.newLine();
    }
}