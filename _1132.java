package Problem_Solve;

import java.io.*;
import java.util.PriorityQueue;

public class _1132 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] priority = new int[10][52];
        char[][] word = new char[N][12];
        boolean[] check = new boolean[10];
        for (int i = 0; i < N; i++) {
            char[] cur = br.readLine().toCharArray();
            word[i] = cur;
            for (int j = cur.length-1, k = 49; j >= 0; j--, k--) {
                priority[cur[j]-'A'][k]++;
                check[cur[j]-'A'] = true;
            }
            priority[cur[0]-'A'][50] = 1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(N, ((o1, o2) -> {
            for (int i = 0; i < o1.length-2; i++) {
                if (o1[i] != o2[i]) {
                    return o2[i] - o1[i];
                }
            }
            return 0;
        }));
        for (int i = 0; i < 10; i++) {
            if (check[i]) {
                priority[i][51] = i+1;
                for (int j = 50; j > 0; j--) {
                    priority[i][j-1] += priority[i][j] / 10;
                    priority[i][j] %= 10;
                }
                pq.add(priority[i]);
            }
        }
        int[] num = new int[10];
        int notFirst = -1;
        int cnt = 9;
        while (cnt >= 0 && !pq.isEmpty()) {
            int[] cur = pq.remove();
            if (cur[50] == 0) {
                notFirst = cur[51];
            }
            num[cnt--] = cur[51];
            if (cnt < 0) {
                if (notFirst >= 0 && num[0] != 0 && num[0] != notFirst && cur[50] == 1) {
                    for (int i = 0; i < 10; i++) {
                        if (num[i] == notFirst) {
                            for (int j = i; j > 0; j--) {
                                num[j] = num[j-1];
                            }
                            num[0] = notFirst;
                            break;
                        }
                    }
                }
            }
        }
        long res = 0;
        for (char[] i : word) {
            String s = "";
            for (int j = 0; j < i.length; j++) {
                for (int k = 0; k < 10; k++) {
                    if (i[j]-'A'+1 == num[k]) {
                        s += String.valueOf(k);
                        break;
                    }
                }
            }
            res += Long.parseLong(s);
        }
        System.out.println(res);
    }
}