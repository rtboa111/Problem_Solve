package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
/*
 * 일정 높이이상의 나무를 잘라 나온 길이가
 * 목표 길이가 되도록하는 높이의 최대값 구하기
 *
 * 높이값의 최대 최소를 구한 뒤 해당높이로
 * 나무를 자를 때의 결과를 바이너리 서치로 구함
 * (high bound 이므로 같을때 lo 를 올려주고 마지막 나온 값에서 1을 빼줌)
 */
public class _2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        System.out.println(binary_search_hiBound(trees, 0, Math.max(max, M), M));
    }
    static int binary_search_hiBound(int[] trees, int lo, int hi, int M) {
        while (lo<hi) {
            int mid = (lo + hi) / 2;
            long height = trees_cut_maximum_height(trees, mid);
            if (M > height) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo-1;
    }
    static long trees_cut_maximum_height(int[] trees, int mid) {
        long sum = 0;
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] > mid)
                sum += trees[i] - mid;
        }
        return sum;
    }
}
