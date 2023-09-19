package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<int[]> jewelry = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelry.add(new int[]{m, v});
        }
        jewelry.sort((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
        int j = 0;
        long res = 0;
        for (int i : bag) {
            while (j < n && jewelry.get(j)[0] <= i) {
                pq.add(new int[]{jewelry.get(j)[0], jewelry.get(j++)[1]});
            }
            if (pq.isEmpty()) continue;
            res += pq.remove()[1];
        }
        System.out.println(res);
    }
}
