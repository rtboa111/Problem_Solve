package Problem_Solve;

import java.io.*;
import java.util.*;

public class _15686 {

    static int N, M, res;
    static final int INF = (1 << 20);
    static ArrayList<int[]> chicken, house;
    static ArrayList<ArrayList<Integer>> length;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>(M);
        house = new ArrayList<>(N << 1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 1) {
                    house.add(new int[]{i, j});
                } else if (cur == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        length = new ArrayList<>();
        for (int i = 0; i < chicken.size(); i++) {
            length.add(new ArrayList<>());
            for (int j = 0; j < house.size(); j++) {
                length.get(i).add(0);
            }
        }
        for (int i = 0; i < chicken.size(); i++) {
            int[] c = chicken.get(i);
            ArrayList<Integer> cur = length.get(i);
            for (int j = 0; j < house.size(); j++) {
                int[] h = house.get(j);
                cur.add(j, Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]));
            }
        }

        check = new boolean[chicken.size()];
        res = INF;
        brute(0, 0);

        System.out.println(res);
    }
    static void brute(int cnt, int last) {
        if (cnt == M) {
            res = Math.min(res, minLen());
            return;
        }
        for (int i = last; i < chicken.size(); i++) {
            if (!check[i] && last < i) {
                check[i] = true;
                brute(cnt + 1, i);
                check[i] = false;
            }
        }
    }

    static int minLen() {
        int[] len = new int[house.size()];
        for (int i = 0; i < chicken.size(); i++) {
            if (check[i]) {
                ArrayList<Integer> cur = length.get(i);
                for (int j = 0; j < len.length; j++) {
                    len[j] = Math.min((len[j] == 0) ? INF : len[j], cur.get(j));
                }
            }
        }
        int ans = 0;
        for (int i : len) {
            ans += i;
        }
        return ans;
    }
}