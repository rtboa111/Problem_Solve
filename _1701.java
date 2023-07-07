package Problem_Solve;

import java.io.*;

public class _1701 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();
        int len = string.length;

        int max = 0;
        int[] pi = new int[len];
        for (int i = 0; i < len; i++) {
            int b = 0;
            for (int a = 1 + i; a < len; a++) {
                while(b > 0 && string[a] != string[b+i]) {
                    b = pi[b-1];
                }
                if (string[a] == string[b+i]) {
                    max = Math.max(max, ++b);
                }
                pi[a-i] = b;
            }
        }
        System.out.println(max);
    }
}