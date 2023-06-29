package Problem_Solve;

import java.io.*;
import java.util.*;

public class _16953 {
    static final int MAX = 1000000000;
    static HashMap<Long, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        map = new HashMap<>(1000000);
        map.put((long) A, 0);
        dfs(A, 0);
        if (map.containsKey((long) B)) {
            System.out.println(map.get((long) B)+1);
        } else {
            System.out.println(-1);
        }
    }
    static void dfs(long cur, int cnt) {
        if (cur > MAX) {
            return;
        }
        map.put(cur, cnt);

        if (map.getOrDefault(cur*2, MAX) > cnt + 1) {
            dfs(cur*2, cnt +1);
        }

        String s = String.valueOf(cur);
        s += "1";
        cur = Long.parseLong(s);
        if (map.getOrDefault(cur, MAX) > cnt + 1) {
            dfs(cur, cnt +1);
        }
    }
}