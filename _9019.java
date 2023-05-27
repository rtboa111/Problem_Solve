package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map = new HashMap<>();
            q = new LinkedList<>();
            /*
             * bfs 로 탐색시 특정 숫자의 도달하는 비용은
             * 항상 처음도달이 최소이므로 다음 도달은 처리하지 않는다.
             */
            check = new boolean[10001];
            map.put(a, "");
            q.add(a);
            while (!check[b]) {
                a = q.remove();
                String cur = map.get(a);
                for (int j = 0; j < 4; j++) {
                    DSLR(a, cur, j);
                }
            }

            bw.write(map.get(b));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static Queue<Integer> q;
    static HashMap<Integer, String> map;
    static boolean[] check;
    static void DSLR(int a, String cur, int order) {

        if (order == 0) {
            cur += "D";
            a = D(a);
        } else if (order == 1) {
            cur += "S";
            a = S(a);
        } else if (order == 2) {
            cur += "R";
            a = R(a);
        }else {
            cur += "L";
            a = L(a);
        }
        if (!check[a]) {
            map.put(a, cur);
            check[a] = true;
            q.add(a);
        }
    }
    static int D(int x) {
        return ((x << 1) % 10000);
    }
    static int S(int x) {
        return (x + 9999) % 10000;
    }
    static int L(int x) {
        int tmp = x / 1000;
        tmp += (x % 1000) * 10;
        return tmp;
    }
    static int R(int x) {
        int tmp = (x % 10) * 1000;
        tmp += x / 10;
        return tmp;
    }
}
