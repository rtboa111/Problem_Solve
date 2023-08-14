package Problem_Solve.Arena.GrandArena_2;

import java.io.*;
import java.util.StringTokenizer;

public class F {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            boolean[][] check = new boolean[n+1][7];
            check[0][1] = true;
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char o1 = st.nextToken().charAt(0);
                int n1 = Integer.parseInt(st.nextToken());
                char o2 = st.nextToken().charAt(0);
                int n2 = Integer.parseInt(st.nextToken());
                for (int j = 0; j < 7; j++) {
                    if (check[i-1][j]) {
                        if (o1 == '+') {
                            check[i][(j + n1) % 7] = true;
                        } else {
                            check[i][(j * n1) % 7] = true;
                        }
                        if (o2 == '+') {
                            check[i][(j + n2) % 7] = true;
                        } else {
                            check[i][(j * n2) % 7] = true;
                        }
                    }
                }
            }
            if (check[n][0]) {
                bw.write("LUCKY");
            } else {
                bw.write("UNLUCKY");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

