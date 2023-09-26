package Problem_Solve.Codeforce.Round_899;

import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N+1];
            int p = 0;
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if (arr[j] >= 0) p = j;
            }
            long res = 0;
            while (p > 0) {
                if (p % 2 == 1) {
                    res += arr[p--];
                } else {
                    boolean flag = false;
                    for (int j = p-1; j > 0; j--) {
                        if ((j%2==1 && arr[j] >= 0) || (j%2==0 && arr[j] <= 0)) {
                            res += arr[p--];
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        res += Math.max(0, arr[1] + arr[2]);
                        for (int j = p; j > 2; j--) {
                            if (j%2==1) continue;
                            res += Math.max(0, arr[j]);
                        }
                        break;
                    }
                }
                while (arr[p] < 0) p--;
            }
            bw.write(String.valueOf(res));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
