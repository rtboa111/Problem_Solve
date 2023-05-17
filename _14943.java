package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _14943 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int deliver = 0;
        long cost = 0;

        for (int i = 0; i < N; i++) {
            cost += Math.abs(deliver);
            deliver += Integer.parseInt(st.nextToken());
        }

        System.out.println(cost);
    }
}