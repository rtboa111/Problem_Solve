package Problem_Solve.Codeforce.Round_899;

import java.io.*;
import java.util.*;

public class B {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[51];
            ArrayList<LinkedList<Integer>> link = new ArrayList<>(51);
            for (int j = 0; j <= 50; j++) link.add(new LinkedList<>());

            ArrayList<LinkedList<Integer>> board = new ArrayList<>(N+1);
            for (int j = 0; j < N; j++) board.add(new LinkedList<>());

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board.get(j).add(num);
                    arr[num]++;
                    link.get(num).add(j);
                }
            }
            int max = 0;
            for (int k : arr) {
                if (k == 0) continue;
                max++;
            }

            int res = 0;
            for (int j = 1; j <= 50; j++) {
                LinkedList<Integer> cur = link.get(j);
                if (cur.isEmpty()) continue;
                for (int k : cur) {
                    for (int z : board.get(k)) {
                        arr[z]--;
                    }
                }
                int cnt = 0;
                for (int k : arr) {
                    if (k == 0) continue;
                    cnt++;
                }
                for (int k : cur) {
                    for (int z : board.get(k)) {
                        arr[z]++;
                    }
                }
                res = Math.max(res, cnt);
            }
            bw.write(String.valueOf(res));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
