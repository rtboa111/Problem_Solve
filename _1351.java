package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1351 {

    static int P, Q;
    static Map<Long, Long> memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        memory = new HashMap<>();

        long res = dfs(N);

        System.out.println(res);
    }
    static long dfs(long cur) {
        if (cur == 0) {
            return 1;
        }
        if (!memory.containsKey(cur)) {
            memory.put(cur, dfs(cur/P)+dfs(cur/Q));
        }
        return memory.get(cur);
    }
}