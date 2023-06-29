package Problem_Solve;

import java.io.*;
import java.util.*;

public class _17144 {

    static int R, C, T, low, hi;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        room = new int[R][C];
        low = 0; hi = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int cur = Integer.parseInt(st.nextToken());
                room[i][j] = cur;
                if (cur == -1) {
                    if (hi == 0) {
                        hi = i;
                    } else {
                        low = i;
                    }
                }
            }
        }
        for (int i = 0; i < T; i++) {
            diffusion();
            circulation();
        }
        int sum = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += room[i][j];
            }
        }
        System.out.println(sum);
    }
    static void diffusion() {
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    int x = i, y = j;
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        x += dx[k]; y += dy[k];
                        if (x < R && x >= 0 && y < C && y >= 0 && room[x][y] > -1) {
                            list.add(new int[]{x, y, room[i][j]/5});
                            cnt++;
                        }
                        x -= dx[k]; y -= dy[k];
                    }
                    room[i][j] -= (room[i][j]/5*cnt);
                }
            }
        }
        for (int[] i : list) {
            room[i[0]][i[1]] += i[2];
        }
    }
    static void circulation() {
        int x = hi-1; int y = 0;
        while (x > 0) {
            room[x][y] = room[x-1][y];
            x--;
        }
        while (y+1 < C) {
            room[x][y] = room[x][y+1];
            y++;
        }
        while (x < hi) {
            room[x][y] = room[x+1][y];
            x++;
        }
        while (y-1 > 0) {
            room[x][y] = room[x][y-1];
            y--;
        }
        room[x][y] = 0;

        x = low+1; y = 0;
        while (x+1 < R) {
            room[x][y] = room[x+1][y];
            x++;
        }
        while (y+1 < C) {
            room[x][y] = room[x][y+1];
            y++;
        }
        while (x > low) {
            room[x][y] = room[x-1][y];
            x--;
        }
        while (y-1 > 0) {
            room[x][y] = room[x][y-1];
            y--;
        }
        room[x][y] = 0;
    }
}