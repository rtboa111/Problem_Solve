package Problem_Solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.print(recur(N, 0));
    }

    static int recur(int N, int count) {

        if (N < 2) {
            return count;
        }
        int min = Math.min(recur(N / 3, count+1+(N%3)), recur(N /2, count+1+(N%2)));
        return min;
    }
}