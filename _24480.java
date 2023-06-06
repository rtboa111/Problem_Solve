package Problem_Solve;

import java.io.*;
import java.util.*;

public class _24480 {

    static int N, cnt;
    static int[] count;
    static ArrayList<ArrayList<Integer>> linked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken())-1;
        linked = new ArrayList<>(N);
        count = new int[N];
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
        count[R] = cnt++;

        dfs(R);

        for (int i : count) {
            bw.write(i+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int cur) {

        for (int i : linked.get(cur)) {
            if (count[i] == 0) {
                count[i] = cnt++;
                dfs(i);
            }
        }
    }
}