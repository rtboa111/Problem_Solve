package Problem_Solve.Progermmers;

import java.lang.Math;

public class athletic_competition {
    public int solution(int[][] ability) {
        ab = ability;
        result = 0;
        for(int i = 0; i < ab.length; i++) {
            boolean[] check = new boolean[ab.length];
            check[i] = true;
            dfs(check, 0, i, ab[i][0]);
        }

        return result;
    }

    static int result;

    static int[][] ab;

    static void dfs(boolean[] check_stu, int curr_ab,int curr_stu, int score) {
        if(curr_ab+1 == ab[0].length) {
            result = Math.max(score, result);
            return;
        }

        for (int i = 1; i < ab.length; i++) {

            int next = (curr_stu + i) % ab.length;

            if(!check_stu[next]) {

                check_stu[next] = true;
                score += ab[next][curr_ab+1];

                dfs(check_stu, curr_ab + 1, next, score);

                check_stu[next] = false;
                score -= ab[next][curr_ab+1];
            }
        }
    }
}