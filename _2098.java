package Problem_Solve;
import java.io.*;
import java.util.StringTokenizer;

public class _2098 {

    static final int INF = 1 << 28;
    static int N;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new int[N][(1 << N)];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0, 1));
    }
    static int dfs(int start, int visited) {
        if (visited == (1 << N)-1) {
            if (board[start][0] != 0) return dp[start][visited] = board[start][0];
            return INF;
        }
        if (dp[start][visited] != 0) return dp[start][visited];

        dp[start][visited] = INF;

        for (int i = 0; i < N; i++) {
            if (board[start][i] == 0) continue;
            if ((visited & (1 << i)) != 0) continue;
            int num = dfs(i, visited | (1 << i)) + board[start][i];
            dp[start][visited] = Math.min(dp[start][visited], num);
        }
        return dp[start][visited];
    }
}