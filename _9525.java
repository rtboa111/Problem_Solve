package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Deque;

public class _9525 {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N;
    static boolean[] board, diagonal, r, c, rPawn, cPawn;
    static Deque<Integer> rList, cList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new boolean[N*N];
        diagonal = new boolean[(N << 1) - 1];
        rPawn = new boolean[N];
        cPawn = new boolean[N];
        r = new boolean[N];
        c = new boolean[N];
        rList = new LinkedList<>();
        cList = new LinkedList<>();
        for (int i = 0; i < N*N; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            list.add(cur);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "");
            for (int j = 0; j < N; j++) {
                if (st.nextToken().charAt(0) == 'X') {
                    board[i*N+j] = true;
                    rPawn[i] = true;
                    cPawn[i] = true;
                } else {
                    list.get(i+j).add(i*N+j);
                }
            }
        }


    }
    static void chess(int idx, int cnt) {
        ArrayList<Integer> cur = list.get(idx);
        if (cur.size() == 0) {
            chess(idx+1, cnt);
            return;
        }
        for (int i : cur) {
            int x = i / N;
            int y = i % N;
            if (r[x]) {

            } else if (c[y]) {

            }
        }

    }
}