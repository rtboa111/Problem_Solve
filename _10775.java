package Problem_Solve;

import java.io.*;

public class _10775 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parents = new int[G+1];
        for (int i = 1; i <= G; i++) {
            parents[i] = i;
        }
        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            if (flag) continue;
            int gi = find(g);
            if (gi != 0) {
                parents[gi] = gi-1;
                cnt++;
                continue;
            }
            flag = true;
        }
        System.out.println(cnt);
    }
    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}