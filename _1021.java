package Problem_Solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> d = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            d.add(i);
        }
        int[] dis = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            int idx = d.indexOf(dis[i]);
            int j;
            if (d.size() % 2 == 0) {
                j = d.size() / 2 -1;
            } else {
                j = d.size() / 2;
            }

            if (idx <= j) {
                while (d.peekFirst() != dis[i]) {
                    d.addLast(d.removeFirst());
                    count++;
                }
                d.removeFirst();
            } else {
                while (d.peekLast() != dis[i]) {
                    d.addFirst(d.removeLast());
                    count++;
                }
                d.removeLast();
                count++;
            }
        }
        System.out.println(count);
    }
}