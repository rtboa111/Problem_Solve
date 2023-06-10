package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2568 {

    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] link = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            link[i] = new int[]{A, B};
        }

        Arrays.sort(link, (o1, o2) -> o1[0] - o2[0]);

        lis = new int[N+1];
        int[] tracking = new int[N+1];  // lis 에 추가되는 위치
        lis[0] = link[0][1];
        tracking[0] = 0;

        int lo = 0;
        int hi = 1;
        for (int i = 1; i < N; i++) {
            if (lis[hi-1] < link[i][1]) {
                lis[hi] = link[i][1];
                tracking[i] = hi;
                hi++;
            } else {
                int idx = binarySearch(lo, hi, link[i][1]);
                lis[idx] = link[i][1];
                tracking[i] = idx;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        hi--;
        for (int i = N-1; i >= 0; i--) {
            /*
             * 추가되었던 위치와 lis 의 길이인 hi 가 같다면
             * 해당 전깃줄은 자르지 않은 전깃줄이므로 넘어가고
             * 반대인 경우들을 추가함
             */
            if (tracking[i] == hi) {
                hi--;
            } else {
                list.add(link[i][0]);
            }
        }

        bw.write(list.size() + "");
        bw.newLine();
        for (int i = list.size()-1; i >= 0; i--) {
            bw.write(list.get(i)+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int binarySearch(int lo, int hi, int target) {

        while (lo < hi) {
            int mid = (hi + lo) / 2;

            if (target > lis[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}