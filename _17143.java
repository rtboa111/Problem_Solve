package Problem_Solve;

import java.io.*;
import java.util.*;

public class _17143 {

    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<int[]> info;
    static ArrayList<ArrayList<ArrayList<LinkedList<Integer>>>> board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new ArrayList<>(C);
        for (int i = 0; i < C; i++) {
            ArrayList<ArrayList<LinkedList<Integer>>> tmp = new ArrayList<>(R);
            for (int j = 0; j < R; j++) {
                ArrayList<LinkedList<Integer>> tmp2 = new ArrayList<>(C);
                for (int k = 0; k < C; k++) {
                    tmp2.add(new LinkedList<>());
                }
                tmp.add(tmp2);
            }
            board.add(tmp);
        }

        info = new ArrayList<>(M+1);
        info.add(new int[0]);
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if (d == 1) {
                d++;
            } else if (d == 2) {
                d-=2;
            } else if (d == 4){
                d-=3;
            }
            if (d % 2 == 0) s %= ((R-1) * 2);
            else s %= ((C-1) * 2);
            board.get(0).get(r).get(c).add(i);
            info.add(new int[]{r, c, s, d, z});
        }

        int res = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (board.get(i).get(j).get(i).isEmpty()) continue;
                int n = 0;
                int max = 0;
                for (int k : board.get(i).get(j).get(i)) {
                    if (max < info.get(k)[4]) {
                        max = info.get(k)[4];
                        n = k;
                    }
                }
                int[] cur = info.get(n);
                board.get(i).get(j).get(i).clear();
                res += cur[4];
                break;
            }

            if (i == C-1) continue;
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (board.get(i).get(j).get(k).isEmpty()) continue;
                    int n = 0;
                    int max = 0;
                    for (int l : board.get(i).get(j).get(k)) {
                        if (max < info.get(l)[4]) {
                            max = info.get(l)[4];
                            n = l;
                        }
                    }
                    move(n, i);
                }
            }
        }
        System.out.println(res);
    }
    static void move(int n, int time) {
        int[] cur = info.get(n);
        int x = cur[0], y = cur[1], s = cur[2], d = cur[3];

        while (s-- > 0) {
            int xx = x + dx[d], yy = y + dy[d];
            if (obs(xx, yy)) {
                x = xx;
                y = yy;
            } else {
                d = (d + 2) % 4;
                s++;
            }
        }
        info.set(n, new int[]{x, y, cur[2], d, cur[4]});
        board.get(time+1).get(x).get(y).add(n);
    }
    static boolean obs(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}