package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _24445 {

    static int N, M, R, cnt;
    static ArrayList<ArrayList<Integer>> linked;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken())-1;
        result = new int[N];
        linked = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            linked.add(new ArrayList<>());
        }
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            arr.add(new int[]{u, v});
        }
        Collections.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });

        for (int[] i : arr) {
            linked.get(i[0]).add(i[1]);
            linked.get(i[1]).add(i[0]);
        }

        cnt = 1;
        result[R] = cnt++;

        bfs();

        for (int i : result) {
            bw.write(i+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(R);

        while (!q.isEmpty()) {
            int cur = q.remove();

            for (int i : linked.get(cur)) {
                if (result[i] == 0) {
                    result[i] = cnt++;
                    q.add(i);
                }
            }
        }
    }
}