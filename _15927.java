package Problem_Solve;

import java.io.*;

public class _15927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();
        int res = -1, len = string.length;
        for (int i = 0, j = len-1; i < j; i++, j--) {
            if (string[i] != string[j]) {
                res = len;
                break;
            }
        }
        if (res < 0) {
            for (int i = 1; i < len; i++) {
                if(string[i] != string[i-1]) {
                    res = len-1;
                    break;
                }
            }
        }

        System.out.println(res);
    }
}