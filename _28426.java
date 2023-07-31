package Problem_Solve;

import java.io.*;

public class _28426 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        sb.append(3).append(" ");
        for (int i = 2, cnt = 0; cnt < n-1; i+=2, cnt++) {
            sb.append(i * 3).append(" ");
        }
        System.out.println(sb);
    }
}
