package Problem_Solve.Arena.GrandArena_2;

import java.io.*;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        int res = 0;
        if (s1.charAt(0) != 'F' && s1.charAt(0) != 'B') {
            res = Integer.parseInt(s1) + 3;
        } else if (s2.charAt(0) != 'F' && s2.charAt(0) != 'B') {
            res = Integer.parseInt(s2) + 2;
        } else if (s3.charAt(0) != 'F' && s3.charAt(0) != 'B') {
            res = Integer.parseInt(s3) + 1;
        }
        String ans = "";
        boolean flag = false;
        if (res % 3 == 0) {
            ans += "Fizz";
            flag = true;
        }
        if (res % 5 == 0) {
            ans += "Buzz";
            flag = true;
        }

        if (flag) {
            System.out.println(ans);
        } else {
            System.out.println(res);
        }
    }
}