package Problem_Solve.Arena.GrandArena_2;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(n+1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            max = Math.max(max, cur);
        }
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            while (cur << 1 <= max) {
                cur <<= 1;
            }
            pq.add(cur);
        }

        int res = max - pq.peek();
        for (int i = 0; i < n; i++) {
            int num = pq.poll();
            num <<= 1;
            max = Math.max(max, num);
            pq.add(num);
            res = Math.min(res, max - pq.peek());
        }
        System.out.println(res);
    }
}
