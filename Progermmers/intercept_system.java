package Problem_Solve.Progermmers;

import java.util.Arrays;

public class intercept_system {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (int[] o1, int[] o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                return 0;
            }
        });

        int e_range = targets[0][1]-1;
        int M_count = 1;
        int len = targets.length;

        for(int idx = 1; idx < len; idx++) {
            if(e_range >= targets[idx][0]) {
                if(e_range > targets[idx][1]-1) {
                    e_range = targets[idx][1]-1;
                }
                continue;
            }
            e_range = targets[idx][1]-1;
            M_count++;
        }

        return M_count;
    }
}
