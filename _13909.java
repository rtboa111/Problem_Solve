package Problem_Solve;

import java.io.*;

public class _13909 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(sqrt(N));
    }
    static int sqrt(int N) {
        long x = 1;
        for (int i = 0; i < 20; i++) {
            x = (x + (N / x)) >> 1;
        }
        return (int) x;
    }
}