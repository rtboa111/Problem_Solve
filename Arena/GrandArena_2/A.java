package Problem_Solve.Arena.GrandArena_2;

import java.io.*;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long res = (1L+n)*n/2;
        System.out.println(res);
        System.out.println(res*res);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i*i*i;
        }
        System.out.println(ans);
    }
}
