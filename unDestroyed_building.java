package Problem_Solve;

public class unDestroyed_building {

    public int solution(int[][] board, int[][] skill) {
        int R = board.length, C = board[0].length;
        int[][] prefix = new int[R+1][C+1];
        for(int[] i : skill) {
            int add = (i[0] == 1) ? -i[5] : i[5];
            prefix[i[1]][i[2]] += add;
            prefix[i[1]][i[4]+1] -= add;
            prefix[i[3]+1][i[2]] -= add;
            prefix[i[3]+1][i[4]+1] += add;
        }
        int res = 0;
        for(int i = 1; i <= R; i++) {
            prefix[i][0] += prefix[i-1][0];
        }
        for(int i = 1; i <= C; i++) {
            prefix[0][i] += prefix[0][i-1];
        }
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                prefix[i][j] += prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                res += (prefix[i][j] + board[i][j] > 0) ? 1 : 0;
            }
        }

        return res;
    }
}