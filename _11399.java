package Problem_Solve;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ATM 돈 인출 최소 시간
 *
 * 걸리는 시간이 오름차순이여야 최종 인출 시간이
 * 최소이기 때문에 배열 정렬 후
 * 모든 요소 합 출력
 */
public class _11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] person = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(person);
        int sum = 0;
        for (int i = 1; i <N; i++) {
            person[i] += person[i-1];
            sum += person[i-1];
        }
        System.out.println(sum + person[N-1]);
    }
}
