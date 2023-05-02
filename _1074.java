package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _1074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())+1;
        int c = Integer.parseInt(st.nextToken())+1;
        int temp = 1 << N - 1;
        int result = 0;
        /*
         * 배열을 4등분 하였을 때 위치에 따른 가중치를
         * 부여하여 계산함.
         * Top-Down 방식
         */
        while (temp > 0) {
            int a = 0;  // 가중치
            if (r > temp && c > temp) { // 둘 다 넘는 경우
                a += 3;
                r -= temp;
                c -= temp;
            } else if (r > temp) {  // y 값만 넘는 경우
                a += 2;
                r -= temp;
            } else if (c > temp) {  // x 값만 넘는 경우
                a += 1;
                c -= temp;
            }
            result += a * (temp * temp);
            temp = temp >> 1;
        }
        System.out.println(result);
    }
}