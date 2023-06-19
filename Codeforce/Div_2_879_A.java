package Problem_Solve.Codeforce;

import java.io.*;
import java.util.*;

public class Div_2_879_A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0 ; i< t; i ++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = 0;
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == -1) {
                    m++;
                }
            }
            if ((m * 2) > n) {
                int cnt = 0;
                while (m * 2 > n || ((m * 2) <= n && m % 2 == 1)){
                    m--;
                    cnt++;
                }
                m = cnt;
            } else {
                m %= 2;
            }
            bw.write(m+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}