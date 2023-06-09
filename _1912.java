package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int prefixSum = 0;
        int min = 0;    // 해당 인덱스 이전 값들중 가장 낮은 값 저장
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            min = Math.min(min, prefixSum);
            prefixSum = prefixSum + Integer.parseInt(st.nextToken());
            max = Math.max(max, prefixSum - min);
        }

        System.out.println(max);
    }
}