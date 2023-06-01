package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _28136 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dish = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            dish[i] = cur;
        }
        dish[N] = dish[0];
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dish[i-1] >= dish[i]) {
                count++;
            }
        }
        System.out.println(count);

        /*
         * 시계방향으로 보았을때
         */
        /*
        int count = 0;
        int rear = dish[0];
        int head = 0;
        for (int i = 1; i < N << 1; i++) {
            if (dish[i-1] >= dish[i]) {
                if (rear > dish[i]) {
                    do {
                        i++;
                    } while (rear > dish[i] && dish[i-1] < dish[i]);
                }
                count++;
                rear = dish[i];
                if (i > N)  {
                    if (rear == head) count--;
                    break;
                }
                if (head == 0) {
                    head = dish[i];
                }
            }
        }
        System.out.println(count);
        int a = 4;
        int b = 6;
        switch (a) {
            case a < b:

        }*/
    }
}