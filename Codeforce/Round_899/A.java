package Problem_Solve.Codeforce.Round_899;

import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = 1;
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == cur) cur++;
                if (j == n-1) {
                    continue;
                }
                cur++;
            }
            bw.write(String.valueOf(cur));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
