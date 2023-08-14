package Problem_Solve.utilCup;

import java.io.*;
import java.util.StringTokenizer;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "-");
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (y > Y) {
                cnt++;
            } else if (y == Y) {
                if (m > M) {
                    cnt++;
                } else if (m == M) {
                    if (d >= D) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}

