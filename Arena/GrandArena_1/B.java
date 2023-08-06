package Problem_Solve.Arena.GrandArena_1;

import java.io.*;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] check = new int[10];
        for (int i = 0; i < 5; i++) {
            int cur = Integer.parseInt(br.readLine());
            check[cur]++;
        }
        int idx = 0;
        for (int i : check) {
            if (i % 2 != 0) {
                System.out.println(idx);
                return;
            }
            idx++;
        }
    }
}
