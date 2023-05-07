package Problem_Solve;

import java.io.*;

public class _1676 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int result = 0;
        int count_2 = 0;
        int count_5 = 0;
        for (int j = 2; j <= N; j++) {
            int i = j;
            while (i%10==0 && i!=0) {
                result++;
                i /= 10;
            }
            while (i%5==0 && i!=0){
                count_5++;
                i /= 5;
            }
            while (i%2==0 && i!=0){
                count_2++;
                i /= 2;
            }

        }
        // 2와 5가 각각 1대1 대응이 되어야 인수로 10을 가짐
        result += Math.min(count_2, count_5);
        System.out.println(result);
    }
}