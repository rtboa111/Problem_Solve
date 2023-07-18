package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class _16768 {

    static int n, k;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] filed;
    static boolean[][] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        filed = new char[n][10];
        for (int i = 0; i < n; i++) {
            filed[i] = br.readLine().toCharArray();
        }

        boolean ex = true;
        while (ex) {

            ex = false;
            check = new boolean[n][10];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (filed[i][j] > '0') {
                        check[i][j] = true;
                        if (bfs(i, j, filed[i][j])) {
                            ex = true;
                        }
                    }
                }
            }
            gravity();
        }
        for (char[] i : filed) {
            bw.write(i);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static boolean bfs(int r, int c, char color) {
        boolean ex = false;
        Queue<int[]> q = new LinkedList<>();
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{r, c});
        q.add(new int[]{r, c});

        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int x = cur[0]; int y = cur[1];

            for (int i = 0; i < 4; i++) {
                x += dx[i]; y += dy[i];
                if (x < n && x >= 0 && y < 10 && y >= 0 && filed[x][y] == color && !check[x][y]) {
                    check[x][y] = true;
                    list.add(new int[]{x, y});
                    q.add(new int[]{x, y});
                    cnt++;
                }
                x -= dx[i]; y -= dy[i];
            }
        }
        if (cnt >= k) {
            for (int[] i : list) {
                filed[i[0]][i[1]] = '0';
            }
            ex = true;
        }
        return ex;
    }

    static void gravity() {
        for (int i = 0; i < 10; i++) {
            java.util.Stack<Character> stack = new Stack<>();
            for (int j = 0; j < n; j++) {
                if (filed[j][i] > '0') {
                    stack.add(filed[j][i]);
                    filed[j][i] = '0';
                }
            }
            int idx = n-1;
            while (!stack.isEmpty()) {
                filed[idx--][i] = stack.pop();
            }
        }
    }
}