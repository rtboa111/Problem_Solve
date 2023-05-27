package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2179 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String s;
        HashMap<String, String> map = new HashMap<>();
        String key = "";
        int max = 0;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 1; j <= s.length(); j++) {
                String x = s.substring(0, j);
                if (map.containsKey(x)) {
                    if (max < j) {
                        key = x;
                        map.put(x, map.get(x) + " " + s);
                        max = j;
                    }
                } else {
                    map.put(s.substring(0, j), s);
                }
            }
        }
        if (max != 0) {
            for (String x : map.get(key).split(" ")) {
                bw.write(x);
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}