package Problem_Solve;

import java.io.*;

public class _170103 {

    static final int MAX = 1000001;
    static boolean[] P_num_check = new boolean[MAX];
    static int[] P_num = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        P_num_sieve();
        int N;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            bw.write(goldbach_partition_count(N) + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int goldbach_partition_count(int N) {
        int idx = 0;
        int count = 0;
        int other_num = N;

        while (P_num[idx] < other_num) {    // 절반 이상 탐색한 경우 종료

            other_num = N - P_num[idx];

            if (!P_num_check[other_num]) {
                count++;    // "N-소수"가 소수이면 골드바흐 파티션이다
            }
            idx++;

        }

        return count;
    }
    static void P_num_sieve() { // 에레토스테네스의 체

        P_num_check[0] = P_num_check[1] = true;

        int idx = 0;

        for (int i = 2; (i * i) < MAX; i++) {
            if (!P_num_check[i]) {
                for (int j = (i * i); j < MAX; j += i) {
                    P_num_check[j] = true;
                }
                P_num[idx++] = i;
            }
        }

        for (int i = P_num[--idx]; i < MAX; i++) {
            if (!P_num_check[i]) {
                P_num[idx++] = i;
            }
        }
    }
}
