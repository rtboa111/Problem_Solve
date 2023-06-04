package Problem_Solve;

import java.io.*;
import java.util.*;

public class _14888 {

    static int N, min, max;
    static int[] arr, operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        arr = new int[N];
        operator = new int[4];  // +, -, *, /
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int res) {
        if (idx == N) {
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                if (i == 0) {
                    res += arr[idx];
                    dfs(idx+1, res);
                    res -= arr[idx];
                } else if (i == 1) {
                    res -= arr[idx];
                    dfs(idx+1, res);
                    res += arr[idx];
                } else if (i == 2) {
                    res *= arr[idx];
                    dfs(idx+1, res);
                    res /= arr[idx];
                } else {
                    res /= arr[idx];
                    dfs(idx+1, res);
                    res *= arr[idx];
                }
                operator[i]++;
            }
        }
    }
}