package Problem_Solve.Progermmers;
1
import java.lang.Math;

public class Integer_pair_between_two_circles {
    public long solution(int r1, int r2) {

        double y1 =  1.0 * r1 * r1;
        double y2 =  1.0 * r2 * r2;
        long answer = 0;

        for(int i = 1; i <= r2; i++) {
            double x = 1.0 * i * i;
            int a = (int) Math.floor(Math.sqrt(y2 - x));
            int b = (int) Math.ceil(Math.sqrt(y1 - x));

            answer += (a - b + 1);
        }

        return answer << 2;
    }
}