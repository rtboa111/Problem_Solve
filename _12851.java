package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _12851 {

    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N >= K) {
            bw.write((N - K) +"");
            bw.newLine();
            bw.write("1");
        } else {
            for (int i : bfs(N, K)) {
                bw.write(i+"");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
    static int[] bfs(int n, int k) {
        java.util.Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        Integer[] visit = new Integer[MAX];
        visit[n] = 1;
        q.add(n);
        int time = 0;
        while (visit[k] == null) {

            while (!q.isEmpty()) {
                q2.add(q.remove());
            }
            time++;

            ArrayList<int[]> addList = new ArrayList<>(q2.size()*3);
            while (!q2.isEmpty()) {
                int cur = q2.remove();

                if (cur+1 < MAX) {
                    if (visit[cur+1] == null) {
                        visit[cur+1] = 0;
                        q.add(cur+1);
                    }
                    addList.add(new int[]{cur+1, visit[cur]});
                }
                if (cur-1 >= 0) {
                    if (visit[cur-1] == null) {
                        visit[cur-1] = 0;
                        q.add(cur-1);
                    }
                    addList.add(new int[]{cur-1, visit[cur]});
                }
                if (cur*2 < MAX) {
                    if (visit[cur*2] == null) {
                        visit[cur*2] = 0;
                        q.add(cur*2);
                    }
                    addList.add(new int[]{cur*2, visit[cur]});
                }
            }
            for (int[] i : addList) {
                visit[i[0]] += i[1];
            }
        }
        return new int[]{time, visit[k]};
    }
}