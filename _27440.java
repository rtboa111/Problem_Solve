package Problem_Solve;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class _27440 {

    static Map<Long, Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        map = new HashMap<>();

        System.out.println(dp(N, 0));
    }
    static long dp(long N, long cnt) {
        if (N <= 0) return Long.MAX_VALUE;
        if (N <= 3) {
            if (N == 1) {
                return cnt;
            }
            return cnt + 1;
        }

        cnt += Math.min((map.containsKey(N/2) ? map.get(N/2) + (N % 2) + 1 : dp(N/2, 0) + N % 2 + 1)
                , (map.containsKey(N/3) ? map.get(N/3) + (N % 3) + 1 : dp(N/3, 0) + N % 3 + 1));

        cnt = Math.min(map.getOrDefault(N, cnt), cnt);

        map.put(N, cnt);

        return cnt;
    }
}