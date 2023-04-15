package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Math.min(N, M);
        max = Math.max(N, M);

        StringBuilder sb = new StringBuilder();
        sb.append(GCMeasure()).append("\n").append(LCMultipel());

        System.out.println(sb);
    }
    public static int N,M,min,max;
    public static int LCMultipel() {

        for (int i = min; ; i += min) {
            if (i%max==0) {
                return i;
            }
        }
    }

    public static int GCMeasure() {

        for (int i = min; ; i--) {
            if (N%i==0 && M%i==0) {
                return i;
            }
        }
    }
}

