package Problem_Solve.Progermmers;

import java.util.PriorityQueue;
import java.util.Arrays;

public class operating_system {

    public long[] solution(int[][] program) {
        PriorityQueue<int[]> PQ = new PriorityQueue<int[]>(program.length, (o1, o2) -> {
            if(o1[0] < o2[0]) {
                return -1;
            } else if(o1[0] > o2[0]) {
                return 1;
            } else {
                if(o1[1] < o2[1]) {
                    return -1;
                } else if(o1[1] > o2[1]) {
                    return 1;
                }
                return 0;
            }
        });

        Arrays.sort(program, (o1, o2) -> {
            if(o1[1] < o2[1]) {
                return -1;
            } else if(o1[1] > o2[1]) {
                return 1;
            } else {
                if(o1[0] < o2[0]) {
                    return -1;
                } else if(o1[0] > o2[0]) {
                    return 1;
                }
                return 0;
            }
        });

        long[] answer = new long[11];

        long curr_time = 0;
        int idx = 0;

        while(idx < program.length) {

            answer[0] = program[idx][1];
            PQ.add(program[idx]);
            idx++;

            // answer[i](i > 0) : i 점수의 대기시간
            while (!PQ.isEmpty()) {
                int[] curr = PQ.remove();

                answer[curr[0]] += answer[0] - curr[1]; // 호출된 시점부터 대기한 시간

                answer[0] += curr[2];   // 현재 시간

                // 현재 시간보다 전에 호출된 프로그램 추가
                while(idx < program.length && answer[0] >= program[idx][1]) {
                    PQ.add(program[idx]);
                    idx++;
                }
            }
        }

        return answer;
    }

}