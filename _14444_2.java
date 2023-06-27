package Problem_Solve;

import java.io.*;

public class _14444_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(manacher(br.readLine().toCharArray()));
    }
    static int manacher(char[] s) {
        StringBuilder sb = new StringBuilder();
        int size = s.length;
        for (int i = 0; i < size; i++) {
            sb.append('@').append(s[i]);
        }
        sb.append('@');

        s = sb.toString().toCharArray();
        size = s.length;
        int[] A = new int[s.length];

        int r = 0, p = 0, max = 0;
        for(int i = 0; i < size; i++) {
            if (i <= r) {
                A[i] = Math.min(A[p*2 - i], r - i);
            } else {
                A[i] = 0;
            }
            while(i-A[i] > 0 && i+A[i]+1 < s.length && s[i-A[i]-1] == s[i+A[i]+1]) {
                A[i]++;
            }
            if (r < i + A[i]) {
                r = i + A[i];
                p = i;
            }
            max = Math.max(max, A[i]);
        }

        return max;
    }
}