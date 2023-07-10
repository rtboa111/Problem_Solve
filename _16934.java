package Problem_Solve;

import java.io.*;
import java.util.*;

public class _16934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> name = new HashMap<>(n);
        HashSet<String> prefix = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            String cur = br.readLine();
            boolean flag = false;
            for (int j = 1; j <= cur.length(); j++) {
                if (!prefix.contains(cur.substring(0, j))) {
                    prefix.add(cur.substring(0, j));
                    if (!flag) {
                        bw.write(cur.substring(0, j));
                        flag = true;
                    }
                }
            }
            name.put(cur, name.getOrDefault(cur, 0) + 1);
            if (!flag) {
                if (name.get(cur) == 1) {
                    bw.write(cur);
                } else {
                    bw.write(cur + name.get(cur));
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}