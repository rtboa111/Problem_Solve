package Problem_Solve.Progermmers;
import java.util.Arrays;

public class disk_controller {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) ->  {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int len = jobs.length;
        int time = jobs[0][1] + jobs[0][0];
        int res = jobs[0][1];
        int possible = 0;
        int cnt = 1;
        boolean[] check = new boolean[len];
        check[0] = true;

        while(cnt < len) {
            for(int i = possible; i < len; i++) {
                if(jobs[i][0] > time) {
                    break;
                }
                possible = i;
            }

            if(check[possible] && possible != len-1) {
                check[++possible] = true;
                cnt++;
                res += jobs[possible][1];
                time = jobs[possible][1] + jobs[possible][0];
                continue;
            }

            int idx = 0, min = 1001;
            for(int i = 1; i <= possible; i++) {
                if(!check[i] && min > jobs[i][1]) {
                    min = jobs[i][1];
                    idx = i;
                }
            }
            check[idx] = true;
            cnt++;
            res += time - jobs[idx][0] + jobs[idx][1];
            time += jobs[idx][1];
        }
        return res/len;
    }
}