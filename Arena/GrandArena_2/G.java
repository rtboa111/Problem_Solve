package Problem_Solve.Arena.GrandArena_2;

import java.io.*;
import java.util.*;

public class G {

    static class T implements Comparable<T>{
        int c;
        ArrayList<Integer> arr = new ArrayList<>();
        public T(int c, ArrayList<Integer> arr) {
            this.c = c;
            this.arr.addAll(arr);
        }
        @Override
        public int compareTo(T o) {
            return c - o.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>(N);
        ArrayList<Integer> ans = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr.add(cur);
            ans.add(cur);
        }
        ans.sort(Integer::compare);

        LinkedList<int[]> graph = new LinkedList<>();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            graph.add(new int[]{s, e, c});
        }

        //dijkstra
        HashSet<ArrayList<Integer>> visit = new HashSet<>(1 << 20);
        PriorityQueue<T> pq = new PriorityQueue<>();
        pq.add(new T(0, arr));
        while (!pq.isEmpty()) {
            T cur = pq.remove();

            if (visit.contains(cur.arr)) continue;
            if (ans.equals(cur.arr)) {
                System.out.println(cur.c);
                return;
            }
            visit.add(cur.arr);

            for (int[] i : graph) {
                ArrayList<Integer> tmp = new ArrayList<>(N);
                tmp.addAll(cur.arr);
                int n = tmp.get(i[0]);
                tmp.set(i[0], tmp.get(i[1]));
                tmp.set(i[1], n);
                pq.add(new T(cur.c + i[2], tmp));
            }
        }
        System.out.println(-1);
    }
}
