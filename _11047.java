package Problem_Solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int money = K;
        int count = 0;
        while (money != 0) {
            int a = coins[N-1];
            for (int i = N-1; i >= 0; i--) {
                if (coins[i]<= money) {
                    a = coins[i];
                    break;
                }
            }
            count++;
            money -= a;
        }
        System.out.println(count);
    }
}