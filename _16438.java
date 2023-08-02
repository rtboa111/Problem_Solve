package Problem_Solve;

import java.io.*;

public class _16438 {

    static char[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        res = new char[7][n];
        int mid = (n - 1) / 2;
        divideAndConquer(0, mid, 0, 'A');
        divideAndConquer(mid + 1, n - 1, 0, 'B');
        for (int i = 0; i < 7; i++) {
            res[i][n-1] = 'B';
        }
        for (char[] s : res) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void divideAndConquer(int lo, int hi, int depth, char dir) {
        if (depth >= 7) return;
        int mid = (lo + hi) / 2;

        for (int i = lo; i <= hi; i++) {
            res[depth][i] = dir;
        }

        divideAndConquer(lo, mid, depth + 1, 'A');
        divideAndConquer(mid + 1, hi, depth + 1, 'B');
    }
}

