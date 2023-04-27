package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
/*
 * 별찍기 문제 3의 제곱수인 N에 대해
 * N*N의 정사각형으로 찍는데 가운데는 비워두는 형식
 *
 * 재귀함수를 통해 풀이
 * 크게 보면 9칸으로 나누어 arr[3][3]로
 * 생각해 볼 수 있고 arr[1][1]은 비어 있는 칸이므로
 * 비워둔 칸을 제외하고 재귀적으로 호출하여
 * 쪼갤 수 없는 1이 되면 별을 찍고
 * 비워둔 칸인 경우 공백을 입력함
 */
public class _2447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        star(0, 0, N,false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static StringBuilder sb = new StringBuilder();
    public static char[][] arr;

    public static void star(int x,int y, int N, boolean blank) {
        // 공백인 경우 공백 입력
        if (blank) {
            for (int i = x; i < x+N; i++) {
                for (int j = y; j < y+N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        // 쪼갤 수 없으면 별 찍기
        if (N == 1) {
            arr[x][y] = '*';
            return;
        }
        int size = N/3; // 칸을 나누는 의미
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {

                count++;
                if (count == 5) {   // 공백 칸
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }

    }
}
