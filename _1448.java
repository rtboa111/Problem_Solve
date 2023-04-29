package Problem_Solve;


import java.io.*;
import java.util.Arrays;
/*
 * 주어진 빨대들을 활용해 세 변의 합이
 * 가장 긴 삼각형을 만들고 세 변의 합 출력
 * 불가능하면 -1 출력
 *
 * 배열을 오름차순으로 정렬 한 후
 * 마지막 빨대부터 순서대로 세개가 삼각형이 되면
 * 그 삼각형의 세 변의 합을 줄력하고 안되면 
 * 그 다음 빨대부터 세개로 하면서 삼각형이
 * 가능해 질 때 까지 반복한 후 합을 출력
 */
public class _1448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] straw = new int[N];
        for (int i = 0; i < N; i++) {
            straw[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(straw);
        int i = N-1;
        int sum = straw[i] + straw[i-1] + straw[i-2];
        while (straw[i] >= straw[i-1]+straw[i-2]) {
            i--;
            if (i-2 < 0) {
                sum = -1;
                break;
            }
            sum = straw[i] + straw[i-1] + straw[i-2];
        }
        System.out.println(sum);
    }
}
