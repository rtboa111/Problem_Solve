package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int size = (int) (((N + 1)) * (N * 0.5));
        arr = new int[size+1];
        int idx = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        int step = 2;
        int tmp = step;
        int result = arr[1];
        for (int i = 2; i <= size; i++) {

            arr[i] += sum(i, step);

            if (step == N) {
                result = Math.max(result, arr[i]);
            }

            tmp--;
            if (tmp == 0) {
                step++;
                tmp = step;
            }
        }

        System.out.println(result);
    }
    static int N;
    static int[] arr;
    static int sum(int idx, int step) {
        int leftParent = (idx - step > (int) ((step-1) * ((step-2) * 0.5))) ? arr[idx - step] : -1;
        int rightParent = (idx - step + 1 <= (int) ((step) * ((step-1) * 0.5))) ? arr[idx - step + 1] : -1;
        return Math.max(leftParent, rightParent);
    }
}