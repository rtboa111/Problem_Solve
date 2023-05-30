package Problem_Solve;

import java.io.*;

public class _28135 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            char[] s = String.valueOf(i).toCharArray();
            for (int j = 1; j < s.length; j++) {
                if (s[j-1] == '5' && s[j] == '0') {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count+N);
    }
}

