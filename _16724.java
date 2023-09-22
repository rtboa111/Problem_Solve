package Problem_Solve;

import java.io.*;
import java.util.*;

public class _16724 {

    static int[] link;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        link = new int[n*m];
        for (int i = 0; i < n; i++) {
            char[] cur = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                int num;
                if (cur[j] == 'D') {
                    num = (i+1)*m+j;
                } else if (cur[j] == 'U') {
                    num = (i-1)*m+j;
                } else if (cur[j] == 'R') {
                    num = i*m+j+1;
                } else {
                    num = i*m+j-1;
                }
                link[i*m+j] = num;
            }
        }
        int res = 0;
        int find = -1;
        for (int i = 0; i < n*m; i++) {
            if (link[i] >= 0) {
                res += dfs(i, find--);
            }
        }
        System.out.println(res);
    }
    static int dfs(int cur, int find) {
        if (link[cur] == find) return 1;
        if (link[cur] < 0) return 0;
        int next = link[cur];
        link[cur] = find;
        return dfs(next, find);
    }
}