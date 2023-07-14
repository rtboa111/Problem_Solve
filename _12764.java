package Problem_Solve;

import java.io.*;
import java.util.*;

public class _12764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> arr = new ArrayList<>(n);
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            arr.add(new int[]{p, q});
        }
        arr.sort((o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int[] i : arr) {
            if (!pq2.isEmpty() || (!pq.isEmpty() && pq.peek()[0] <= i[0])) {
                while (!pq.isEmpty() && pq.peek()[0] <= i[0]) {
                    pq2.add(pq.poll());
                }
                int[] cur = pq2.remove();
                list.set(cur[1], list.get(cur[1]) + 1);
                pq.add(new int[]{i[1], cur[1]});
            } else {
                list.add(1);
                pq.add(new int[]{i[1], list.size()-1});
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
