package Problem_Solve;

import java.io.*;
import java.util.*;

public class _5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        loop:
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }

            Arrays.sort(arr, (o1, o2) -> {
                int len = Math.min(o1.length(), o2.length());
                for (int j = 0; j < len; j++) {
                    if (o1.charAt(j) == o2.charAt(j)) {
                        continue;
                    }
                    return o2.charAt(j) - o1.charAt(j);
                }
                return o1.length() - o2.length();
            });

            for(int j = 1; j < n; j++) {
                int len = Math.min(arr[j-1].length(), arr[j].length());
                if (arr[j-1].substring(0, len).equals(arr[j].substring(0, len))) {
                    bw.write("NO");
                    bw.newLine();
                    continue loop;
                }
            }
            bw.write("YES");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}