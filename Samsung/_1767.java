package Problem_Solve.Samsung;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1767 {

    static int N, on_core, wire_len;
    static boolean[][] maxinos;
    static int[] order_x = new int[]{1, 0, -1, 0};
    static int[] order_y = new int[]{0, 1, 0, -1};
    static ArrayList<int[]> core_location;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            maxinos = new boolean[N][N];
            core_location = new ArrayList<>(13);
            on_core = 0;
            wire_len = 0;

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int core = Integer.parseInt(st.nextToken());

                    if (core == 1) {
                        if (j != 0 && k != 0 && j != N-1 && k != N-1) {
                            core_location.add(new int[]{k, j});
                        }
                        maxinos[j][k] = true;
                    }
                }
            }

            DFS(0, maxinos, 0, 0);

            bw.write("#" + i + " " + wire_len);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void DFS(int num_core, boolean[][] taboo, int wire_count, int core_count) {
        if (num_core == core_location.size()) { // 탐색할 코어가 더 없으면 종료
            if (on_core < core_count || (on_core == core_count && wire_len > wire_count)) {
                on_core = core_count;
                wire_len = wire_count;
            }
            return;
        }

        int x = core_location.get(num_core)[0];
        int y = core_location.get(num_core)[1];

        boolean execute = true;
        for (int i = x+1; i < N; i++) {
            if (taboo[y][i]) {
                execute = false;
                break;
            }
        }
        if (execute) {
            DFS(num_core + 1, wire_install(taboo, 0, x, y),
                    wire_count+(N-x-1),core_count+1);
            taboo = wire_uninstall(taboo, 0, x, y);
        }

        execute = true;
        for (int i = y+1; i < N; i++) {
            if (taboo[i][x]) {
                execute = false;
                break;
            }
        }
        if (execute) {
            DFS(num_core + 1, wire_install(taboo, 1, x, y),
                    wire_count+(N-y-1), core_count+1);
            taboo = wire_uninstall(taboo, 1, x, y);
        }

        execute = true;
        for (int i = x-1; i >= 0; i--) {
            if (taboo[y][i]) {
                execute = false;
                break;
            }
        }
        if (execute) {
            DFS(num_core + 1, wire_install(taboo, 2, x, y),
                    wire_count+x, core_count+1);
            taboo = wire_uninstall(taboo, 2, x, y);
        }

        execute = true;
        for (int i = y-1; i >= 0; i--) {
            if (taboo[i][x]) {
                execute = false;
                break;
            }
        }
        if (execute) {
            DFS(num_core + 1, wire_install(taboo, 3, x, y),
                    wire_count+y, core_count+1);
            taboo = wire_uninstall(taboo, 3, x, y);
        }
        DFS(num_core+1, taboo, wire_count, core_count);

        DFS(num_core+1, taboo, wire_count, core_count);
    }
    // 전선 설치
    static boolean[][] wire_install(boolean[][] taboo, int order, int x, int y) {

        while (x < N-1 && y < N-1 && x > 0 && y > 0) {
            x += order_x[order];
            y += order_y[order];
            taboo[y][x] = true;
        }
        return taboo;
    }

    // 전선 해제
    static boolean[][] wire_uninstall(boolean[][] taboo, int order, int x, int y) {

        while (x < N-1 && y < N-1 && x > 0 && y > 0) {
            x += order_x[order];
            y += order_y[order];
            taboo[y][x] = false;
        }
        return taboo;
    }
}
