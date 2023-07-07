package Problem_Solve;
;
import java.io.*;
import java.util.StringTokenizer;

public class _12969 {
    static boolean end;
    static int n, k;
    static char[] string;
    static StringBuilder sb;
    static boolean[][][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        string = new char[n];
        sb = new StringBuilder();
        dp = new boolean[n+1][n+1][n+1][k+1];
        backtracking(0, 0, 0, 0);
        if (end) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
    static void backtracking(int cur, int cnt, int aCnt, int bCnt) {
        if (end) return;
        if (cur == n) {
            if (cnt == k) {
                for (char s : string) {
                    sb.append(s);
                }
                end = true;
            }
            return;
        }

        if (cnt > k || dp[cur][aCnt][bCnt][cnt]) {
            return;
        }

        dp[cur][aCnt][bCnt][cnt] = true;

        string[cur] = 'A';
        backtracking(cur+1, cnt, aCnt+1, bCnt);
        string[cur] = 'B';
        backtracking(cur+1, cnt + aCnt, aCnt, bCnt+1);
        string[cur] = 'C';
        backtracking(cur+1, cnt + aCnt + bCnt, aCnt, bCnt);
    }
}