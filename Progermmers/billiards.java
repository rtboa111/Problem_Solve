package Problem_Solve.Progermmers;

import java.lang.Math;

public class billiards {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int x, y, cur_x, cur_y, fst, sec, thr, fth;
        int[] answer = new int[balls.length];
        x = startX;
        y = startY;

        for (int i = 0; i < balls.length; i++) {
            cur_x = balls[i][0];
            cur_y = balls[i][1];

            fst = (int) (Math.pow(x + cur_x, 2) + Math.pow(y - cur_y, 2));
            sec = (int) (Math.pow((m << 1) - x - cur_x, 2) + Math.pow(y - cur_y, 2));
            thr = (int) (Math.pow(y + cur_y, 2) + Math.pow(x - cur_x, 2));
            fth = (int) (Math.pow((n << 1) - y - cur_y, 2) + Math.pow(x - cur_x, 2));

            if (y == cur_y) {
                if (x > cur_x) {
                    fst = Integer.MAX_VALUE;
                } else {
                    sec = Integer.MAX_VALUE;
                }
            } else if (x == cur_x) {
                if (y > cur_y) {
                    thr = Integer.MAX_VALUE;
                } else {
                    fth = Integer.MAX_VALUE;
                }
            }

            answer[i] = Math.min(fst, Math.min(sec, Math.min(thr, fth)));
        }

        return answer;
    }
}