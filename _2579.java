package Problem_Solve;


import java.io.*;

public class _2579 {

    static int[] temp;
    static int[] temp2;
    static int result = 0;  // 답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] step = new int[N+1];
        for (int i = 1; i <= N; i++) {
            step[i] = Integer.parseInt(br.readLine());  // 계단 마다 점수 기록
        }
        temp = new int[N];
        temp2 = new int[N];

        maximum_point(step,0,0,0);
        System.out.println(result);
    }

    // 1계단 오르는 것과 2계단 오르는 것 두가지를 분기로 하여 재귀함수 구현
    static void maximum_point(int[] step, int stage, int limitTime, int point) {
        point += step[stage];
        if (stage >= step.length - 1) {
            result = Math.max(point, result);
            return;
        }
        if (limitTime == 1) {   // limitTime 이 1일때 최대값 기록
            if (temp[stage] > point) {  // 최대보다 작으면 해당 분기 종료
                return;
            } else {
                temp[stage] = point;    // 최대보다 크면 최대값 기록
            }
        } else {    // limitTime 이 2일때 최대값 기록
            if (temp2[stage] > point) {
                return;
            } else {
                temp2[stage] = point;
            }
        }
        if (limitTime < 2) {
            maximum_point(step,stage+1,limitTime+1, point);
        }
        if (stage + 2 < step.length) {
            // 두계단 오르면 연속계단 카운트 초기화
            maximum_point(step, stage+2, 1, point);
        }
    }
}
