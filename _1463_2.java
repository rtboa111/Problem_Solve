package Problem_Solve;

import java.io.*;

public class _1463_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        calculation(x,0);
        System.out.println(result);
    }
    static int result = Integer.MAX_VALUE;
    static void calculation(int x,int time) {
        if (x <= 1) {
            result = Math.min(time, result);
            return;
        }
        calculation(x/3, time + 1 + (x % 3));
        calculation(x/2, time + 1 + (x % 2));
    }// 두 가지 분기, 해당 수로 나누면 나머지에 대해 -1 연산을 한 것으로 간주
}
