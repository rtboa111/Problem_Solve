package Problem_Solve;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13459 {

    static int n, m, goal, firX, firY;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        int red = -1;
        int blue = -1;
        goal = -1;
        for (int i = 0; i < n; i++) {
            char[] cur = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = cur[j];
                if (cur[j] == '#' || cur[j] == '.') continue;
                switch (cur[j]) {
                    case 'R':
                        red = i*m+j;
                        break;
                    case 'B':
                        blue = i*m+j;
                        break;
                    case 'O':
                        goal = i*m+j;
                        break;
                }
            }
        }
        System.out.println(bfs(red, blue));
    }
    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && board[x][y] != '#' && x*m+y != goal && (x != firX || y != firY);
    }
    static int bfs(int red, int blue) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{red, blue, 1});
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            if (cur[2] > 10) return 0;
            for (int i = 0; i < 4; i++) {
                int[] tmp = execute(cur[0], cur[1], i);
                if (tmp[0] == -1) continue;
                if (tmp[0] == -2) return 1;
                q.add(new int[]{tmp[0], tmp[1], cur[2]+1});
            }
        }
        return 0;
    }

    static int[] execute(int red, int blue, int order) {
        int x = blue/m, y = blue%m;
        int xx = red/m, yy = red%m;
        boolean[] comp = {x > xx, y < yy, x < xx, y > yy};
        firX = 0; firY = 0;
        int tmp, tmp2;
        if (comp[order]) {
            tmp2 = tilt(x, y, order);
            tmp = tilt(xx, yy, order);
        } else {
            tmp = tilt(xx, yy, order);
            tmp2 = tilt(x, y, order);
        }
        if (tmp2 == -1) return new int[]{-1};
        if (tmp == -1) return new int[]{-2};

        return new int[]{tmp, tmp2};
    }
    static int tilt(int x, int y, int order) {
        while (check(x + dx[order], y + dy[order])) {
            x += dx[order];
            y += dy[order];
        }
        if ((x+dx[order])*m+(y+dy[order]) == goal) return -1;
        firX = x; firY = y;
        return x*m+y;
    }
}