package Problem_Solve;
import java.util.PriorityQueue;

public class shuttle_bus {
    public String solution(int n, int t, int m, String[] timetable) {

        int[] busTime = new int[n];
        for(int i = 0; i < n; i++) {
            busTime[i] = 540 + (i * t);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String cur : timetable) {
            int time = Integer.parseInt(cur.substring(0, 2)) * 60;
            time += Integer.parseInt(cur.substring(3, 5));
            pq.add(time);
        }
        int[] busCnt = new int[n];
        String res = "";
        int last = 0;
        loop:
        for(int i = 0; i < n; i++) {
            while (!pq.isEmpty() && busTime[i] >= pq.peek() && busCnt[i] < m) {
                busCnt[i]++;
                last = pq.remove();
            }
        }
        if(busCnt[n-1] < m) {
            last = busTime[n-1];
        } else {
            last--;
        }
        res += (last / 60 < 10) ? "0" + String.valueOf(last / 60) : String.valueOf(last / 60);
        res += ":";
        res += (last % 60 < 10) ? "0" + String.valueOf(last % 60) : String.valueOf(last % 60);
        return res;
    }
}