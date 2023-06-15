package Problem_Solve;

import java.io.*;
import java.util.*;

public class _13975 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>(N+1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long res = 0;
            while (pq.size() > 1) {
                long cur = pq.poll();
                cur += pq.poll();
                res += cur;
                pq.add(cur);
            }
            bw.write(res+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}