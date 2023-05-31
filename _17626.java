package Problem_Solve;

import java.io.*;

public class _17626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int factor = 224;
        fourSquares(N, factor, 0);
        System.out.println(result);
    }
    static int result = 4;
    static void fourSquares(int N, int factor, int count) {
        if (N == 0) {
            result = Math.min(result, count);
        }
        while (factor*factor > N) {
            factor--;
        }
        while (factor > 0 && result > count) {
            fourSquares(N-(factor*factor), factor, count+1);
            factor--;
        }
    }
}