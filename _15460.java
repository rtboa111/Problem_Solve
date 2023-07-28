package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Deque;
import java.util.LinkedList;

public class _15460 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] prefixSum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[N]);
        long max = -1;
        int par = N;
        Deque<Integer> res = new LinkedList<>();
        for (int i = N-1; i >= 2; i--) {
            pq.add(arr[i]);
            long cur = prefixSum[N] - prefixSum[i-1];
            cur -= pq.peek();
            int curP = (N - i);
            if (max * curP <= cur * par) {
                if (max * curP != cur * par) {
                    res = new LinkedList<>();
                }
                max = cur;
                par = curP;
                res.addFirst(i-1);
            }
        }
        for (int i : res) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}