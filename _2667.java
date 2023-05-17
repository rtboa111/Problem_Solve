package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _2667 {

    static int N;
    static boolean[][] map;
    static boolean[][] check;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][N];
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (br.read() == '1') {
                    map[i][j] = true;
                }
            }
            br.readLine();
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) {
                    map[i][j] = false;
                    result.add(bfs(j, i)+1);
                }
            }
        }
        result.sort(Integer::compareTo);
        bw.write(result.size()+"");
        bw.newLine();
        int idx = 0;
        while (!result.isEmpty()) {
            bw.write(result.remove(idx)+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int bfs(int x, int y) {

        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] C = q.remove();

            int dir = 0;
            if (condition(dir, C)) {
                map[C[1]+ dy[dir]][C[0]+ dx[dir]] = false;
                check[C[1]+ dy[dir]][C[0]+ dx[dir]] = true;
                q.add(new int[]{C[0]+ dx[dir], C[1]+ dy[dir]});
                count++;
            }

            dir = 1;
            if (condition(dir, C)) {
                map[C[1]+ dy[dir]][C[0]+ dx[dir]] = false;
                check[C[1]+ dy[dir]][C[0]+ dx[dir]] = true;
                q.add(new int[]{C[0]+ dx[dir], C[1]+ dy[dir]});
                count++;
            }

            dir = 2;
            if (condition(dir, C)) {
                map[C[1]+ dy[dir]][C[0]+ dx[dir]] = false;
                check[C[1]+ dy[dir]][C[0]+ dx[dir]] = true;
                q.add(new int[]{C[0]+ dx[dir], C[1]+ dy[dir]});
                count++;
            }

            dir = 3;
            if (condition(dir, C)) {
                map[C[1]+ dy[dir]][C[0]+ dx[dir]] = false;
                check[C[1]+ dy[dir]][C[0]+ dx[dir]] = true;
                q.add(new int[]{C[0]+ dx[dir], C[1]+ dy[dir]});
                count++;
            }
        }
        return count;
    }

    static boolean condition(int dir, int[] C) {
        return C[0]+ dx[dir] < N && C[1]+ dy[dir] < N
                && C[0]+ dx[dir] >= 0 && C[1]+ dy[dir] >= 0
                && map[C[1]+ dy[dir]][C[0]+ dx[dir]]
                && !check[C[1]+ dy[dir]][C[0]+ dx[dir]];
    }
}