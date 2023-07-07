package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1027 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n];
        double[] building = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            building[i] = Integer.parseInt(st.nextToken())+0.0;
        }
        for (int i = 0; i < n-1; i++) {
            loop:
            for (int j = i+1; j < n; j++) {
                double incline = (building[j] - building[i]) / (j - i);
                for (int k = i+1; k < j; k++) {
                    if ((building[j] - building[k]) / (j - k) <= incline) {
                        continue loop;
                    }
                }
                cnt[i]++; cnt[j]++;
            }
        }
        int res = 0;
        for (int i : cnt) {
            res = Math.max(res, i);
        }
        System.out.println(res);
    }
}