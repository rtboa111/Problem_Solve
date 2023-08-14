package Problem_Solve.utilCup;

import java.io.*;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur >= 300) {
                bw.write("1");
            } else if (cur >= 275) {
                bw.write("2");
            } else if (cur >= 250) {
                bw.write("3");
            } else {
                bw.write("4");
            }
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}

