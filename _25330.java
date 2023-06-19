package Problem_Solve;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _25330 {

    static int K, N, res;
    static int[][] town;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        town = new int[N][2];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            town[i][0] = Integer.parseInt(st.nextToken());
            town[i][1] = Integer.parseInt(st2.nextToken());
        }

        map = new HashMap<>();
        res = 0;
        dfs(K, 0, 0);

        System.out.println(res);
    }
    static HashMap<Integer, Integer> map;
    static void dfs(int k, int save, int sum) {
        if (k < 0) {
            return;
        }

        map.put(k, save);

        res = Math.max(res, save);

        for (int i = 0; i < N; i++) {
            int tmp = k - (sum + town[i][0]);
            if (!visit[i] && map.getOrDefault(tmp, 0) < save + town[i][1]) {
                visit[i] = true;

                dfs(tmp, save + town[i][1], sum + town[i][0]);

                visit[i] = false;
            }
        }

    }
}