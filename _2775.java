package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
/*
 * 아파트에 거주하는 인원 출력
 *
 * 주어진 층,호수의 인원을 아는데 필요한 만큼만
 * 인원을 체크하고 출력함.
 */
public class _2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[][] apart = new int[15][15];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int floor = Integer.parseInt(br.readLine());
            int num = Integer.parseInt(br.readLine());
            getIn(apart,floor,num);
            sb.append(apart[num][floor]).append("\n");
        }
        System.out.println(sb);
    }
    public static int[] check = new int[15];
    public static void getIn(int[][] a, int floor, int num) {
        if (check[0] < num) {
            for (int i = check[0]+1; i <= num; i++) {
                a[i][0] = i;
            }
            check[0] = num;
        }
        for (int i = 1; i <= floor; i++) {
            for (int j = check[i]+1; j <= num; j++) {
                a[j][i] = a[j][i-1]+a[j-1][i];
            }
            check[i] = num;
        }
    }
}
