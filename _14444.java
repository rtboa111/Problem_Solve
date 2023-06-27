package Problem_Solve;

import java.io.*;

public class _14444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(manacherCorrection(br.readLine().toCharArray()));
    }
    static int manacherCorrection(char[] s) {
        StringBuilder sb = new StringBuilder();
        int size = s.length;
        for (int i = 0; i < size; i++) {
            sb.append('@').append(s[i]);
        }
        sb.append('@');

        s = sb.toString().toCharArray();
        size = s.length;

        int R = 0;
        for(int i = 1; i < size; i++) {
            int r = R+1;
            if (i-r >= 0 && i+r < size) {
                while(r >= 0 && s[i-r] == s[i+r]) {
                    r--;
                }
            } else {
                break;
            }
            if (r < 0) {
                r = R + 2;
                while(i-r >= 0 && i+r < s.length && s[i-r] == s[i+r]) {
                    r++;
                }
                R = r-1;
            }
        }
        return R;
    }
}