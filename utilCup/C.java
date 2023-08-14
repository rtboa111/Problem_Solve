package Problem_Solve.utilCup;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            arr[i] = cur;
        }
        Arrays.sort(arr);
        int lv = 0;
        int ab = 0;
        for (int i = n-1; i >= Math.max(n-42, 0); i--) {
            lv += arr[i];
            if (arr[i] >= 250) {
                ab += 5;
            } else if (arr[i] >= 200) {
                ab += 4;
            } else if (arr[i] >= 140) {
                ab += 3;
            } else if (arr[i] >= 100) {
                ab += 2;
            } else if (arr[i] >= 60) {
                ab++;
            }
        }
        System.out.println(lv + " " + ab);
    }
}

