package Problem_Solve.Progermmers;

import java.util.Deque;
import java.util.LinkedList;

public class equal_the_sum_of_two_queue {
    public int solution(int[] queue1, int[] queue2) {
        long q1Sum = 0;
        long q2Sum = 0;

        Deque<Long> q1 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++) {
            long tmp = queue1[i];
            q1Sum += tmp;
            q1.add(tmp);
        }
        Deque<Long> q2 = new LinkedList<>();
        for(int i = 0; i < queue2.length; i++) {
            long tmp = queue2[i];
            q2Sum += tmp;
            q2.add(tmp);
        }

        int end = (q1.size() + q2.size()) * 4;
        int cnt = 0;
        while(cnt < end) {
            if(q1Sum > q2Sum) {
                long tmp = q1.remove();
                q1Sum -= tmp;

                q2.add(tmp);
                q2Sum += tmp;
            } else if(q1Sum < q2Sum) {
                long tmp = q2.remove();
                q2Sum -= tmp;

                q1.add(tmp);
                q1Sum += tmp;
            } else {
                break;
            }
            cnt++;
        }

        return (cnt == end) ? -1 : cnt;
    }
}