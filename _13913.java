package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class _13913 {
    static int N, M, time, lastTime;
    static final int MAX_INDEX = 100001;
    static boolean[] visit = new boolean[MAX_INDEX];
    static LinkedList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new LinkedList<>();
        if (N >= M) {
            bw.write(N - M +"");
            bw.newLine();
            for (int i = N; i >= M; i--) {
                bw.write(i+" ");
            }
        } else {
            map = new HashMap<>();
            time = 0;
            lastTime = MAX_INDEX;
            bfs();

            if (lastTime > time) {
                result = map.get(M);
                bw.write(time+"");
            } else {
                bw.write(lastTime+"");
            }
            bw.newLine();
            if (result.getLast() != M) {
                result.add(M);
            }
            for (int i : result) {
                bw.write(i+" ");
            }
        }
        bw.flush();
        bw.close();
    }
    static Map<Integer, LinkedList<Integer>> map;
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(N);
        visit[N] = true;

        while (!q.isEmpty()) {

            while (!q.isEmpty()) {
                int cur = q.remove();
                if (cur == M || time >= lastTime) {
                    q.clear();
                    q2.clear();
                    return;
                } else if (cur > M) {
                    if (lastTime > time + (cur - M)) {
                        result = map.remove(cur);
                        for (int i = cur; i >= M; i--) {
                            result.add(i);
                        }
                        lastTime = time + (cur - M);
                    }
                    continue;
                }
                q2.add(cur);
            }

            while (!q2.isEmpty()) {
                int cur = q2.remove();

                cur *= 2;
                if (cur < MAX_INDEX && !visit[cur]) {
                    visit[cur] = true;
                    LinkedList<Integer> list = new LinkedList<>();
                    if (map.containsKey(cur/2)) {
                        list.addAll(map.get(cur / 2));
                    }
                    list.add(cur/2);
                    map.put(cur, list);
                    q.add(cur);
                }

                cur /= 2; cur++;
                if (cur < MAX_INDEX && !visit[cur]) {
                    visit[cur] = true;
                    LinkedList<Integer> list = new LinkedList<>();
                    if (map.containsKey(cur-1)) {
                        list.addAll(map.get(cur-1));
                    }
                    list.add(cur-1);
                    map.put(cur, list);
                    q.add(cur);
                }

                cur -= 2;
                if (cur >= 0 && !visit[cur]) {
                    visit[cur] = true;
                    LinkedList<Integer> list = new LinkedList<>();
                    if (map.containsKey(cur+1)) {
                        list.addAll(map.get(cur+1));
                    }
                    list.add(cur+1);
                    map.put(cur, list);
                    q.add(cur);
                }

                map.remove(cur+1);
            }

            time++;
        }
    }
}
