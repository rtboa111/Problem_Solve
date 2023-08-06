package Problem_Solve.Arena.GrandArena_1;

import java.io.*;
import java.util.HashSet;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int idx = -1;
        for (int i = 0; i < n; i++) {
            String S = br.readLine();
            arr[i] = S;
            if (S.charAt(0) == '?') {
                idx = i;
                continue;
            }
            set.add(S);
        }

        char[] b = new char[2];
        if (idx > 0) {
            b[0] = arr[idx-1].charAt(arr[idx-1].length()-1);
        }
        if (idx < n-1) {
            b[1] = arr[idx+1].charAt(0);
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String S = br.readLine();
            if (!set.contains(S)) {
                if (idx > 0 && b[0] != S.charAt(0)) {
                    continue;
                }
                if (idx < n-1 && b[1] != S.charAt(S.length()-1)) {
                    continue;
                }
                System.out.println(S);
            }
        }
    }
}
