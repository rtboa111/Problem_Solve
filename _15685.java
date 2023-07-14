package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Deque;
import java.util.Queue;

public class _15685 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean[][] coordinate = new boolean[101][101];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int gene = 0;
            coordinate[x][y] = true;
            x += dx[d]; y += dy[d];
            coordinate[x][y] = true;
            Deque<Integer> deque = new LinkedList<>();
            deque.add(d);
            while (gene < g) {
                java.util.Queue<Integer> q2 = new LinkedList<>();
                Queue<Integer> q3 = new LinkedList<>();
                while (!deque.isEmpty()) {
                    q3.add(deque.poll());
                }

                while (!q3.isEmpty()) {
                    int order = q3.poll();
                    q2.add(order);
                    order = (order + 5) % 4;
                    x += dx[order]; y += dy[order];
                    coordinate[x][y] = true;
                    deque.addFirst(order);
                }

                while (!q2.isEmpty()) {
                    deque.add(q2.poll());
                }

                gene++;
            }
        }
        int cnt = 0;
        for (int i = 0; i <= 99; i++) {
            loop:
            for (int j = 0; j <= 99; j++) {
                for (int x = i; x < i+2; x++) {
                    for (int y = j; y < j+2; y++) {
                        if (!coordinate[x][y]) {
                            continue loop;
                        }
                    }
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}