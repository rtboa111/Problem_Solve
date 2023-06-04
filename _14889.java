package Problem_Solve;

import java.io.*;
import java.util.*;

public class _14889 {

    static int N, min;
    static int[] ability, ft;
    static boolean[] firT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        ability = new int[N*N];
        firT = new boolean[N];
        ft = new int[N];
        firT[0] = true;
        ft[0] = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i*N+j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                ability[i*N+j] += ability[j*N+i];
            }
        }

        dfs(1);

        System.out.println(min);
    }

    static void dfs(int idx) {
        if (idx == (N >> 1)) {

            int point = 0;
            // 다른팀 점수 빼줌
            for (int i = 0; i < N; i++) {
                if (!firT[i]) {
                    for (int j = i+1; j < N; j++) {
                        if (!firT[j]) {
                            point -= ability[i*N+j];
                        }
                    }
                }
                else {
                    for (int j = i+1; j < N; j++) {
                        if (firT[j]) {
                            point += ability[i*N+j];
                        }
                    }
                }
            }

            min = Math.min(min, Math.abs(point));
            return;
        }

        // 1번 선수가 주장인 팀
        for (int i = 1; i < N; i++) {
            if (!firT[i] && ft[idx-1] < i) {
                firT[i] = true;
                ft[idx] = i;
                dfs(idx+1);
                firT[i] = false;
            }
        }
    }
}