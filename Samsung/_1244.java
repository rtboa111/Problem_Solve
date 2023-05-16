package Problem_Solve.Samsung;

import java.io.*;
import java.util.StringTokenizer;

public class _1244 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        int[] num;
        int time;
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            num = new int[s.length()];
            int idx = 0;
            for (char c : s.toCharArray()) {
                num[idx++] = c - '0';
            }

            time = Integer.parseInt(st.nextToken());
            max = 0;
            change(num, time, 0);
            bw.write("#" + i + " " + max);
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    static int max;
    static int[] check = new int[1000000];
    static void change(int[] num, int time, int target) {
        // num 을 int 로 변환
        int x = 0;
        int idx = 1;
        for (int i = num.length-1; i >= 0; i--) {
            x += (num[i] * idx);
            idx *= 10;
        }

        // 탐색했던 경우 종료
        if (check[x] == time+1) {
            return;
        }
        check[x] = time+1;

        if (time == 0) {
            max = Math.max(max, x); // 최대값 저장
            return;
        }
        while (target < num.length-1) {
            for (int i = target + 1; i < num.length; i++) {
                num = swap(num, target, i);
                change(num, time-1, target);
                num = swap(num, i, target);
            }
            target++;
        }

    }
    static int[] swap(int[] num, int from, int to) {    // 위치교환
        int temp = num[from];
        num[from] = num[to];
        num[to] = temp;
        return num;
    }
}