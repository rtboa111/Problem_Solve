package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(N);
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int res = 0;
        while (pq.size() > 1) {
            int cur = pq.poll();
            cur += pq.poll();
            res += cur;
            pq.add(cur);
        }
        bw.write(res+"");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
