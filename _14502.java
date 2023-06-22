package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _14502 {

    static int n, m, pos, res;
    static int[] map;
    static ArrayList<Integer> list;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new int[n*m];
        pos = -3;
        for(int i= 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j < m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i*m+j] = cur;
                if (cur == 2) {
                    list.add(i*m+j);
                } else if(cur == 0) {
                    pos++;
                }
            }
        }
        dfs(0);

        System.out.println(res);
    }
    static void dfs(int cnt) {
        if (cnt == 3) {
            res = Math.max(res, check(map.clone()));
            return;
        }
        for(int i= 0; i < n; i++) {
            for(int j= 0; j < m; j++) {
                if(map[i*m+j] == 0) {
                    map[i*m+j] = 1;
                    dfs(cnt + 1);
                    map[i*m+j] = 0;
                }
            }
        }
    }

    static int check(int[] fixMap) {
        Queue<Integer> q = new LinkedList<>();
        for (int i : list) {
            q.add(i);
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.remove();
            int x = cur / m;
            int y = cur % m;

            for(int i = 0; i < 4; i++) {
                x += dx[i]; y += dy[i];
                if(x < n && x >= 0 && y < m && y >= 0 && fixMap[x*m+y] == 0) {
                    cnt++;
                    fixMap[x*m+y] = 2;
                    q.add(x*m+y);
                }
                x -= dx[i]; y -= dy[i];
            }
        }
        return pos - cnt;
    }
}