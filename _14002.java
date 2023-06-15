package Problem_Solve;

import java.io.*;
import java.util.*;

public class _14002 {

    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(N+1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list.add(new ArrayList<>());
        }
        list.add(new ArrayList<>());
        lis = new int[N+1];
        list.get(0).add(arr[0]);
        lis[0] = arr[0];

        int lo = 0;
        int hi = 1;
        for (int i = 1; i < N; i++) {
            if (lis[hi-1] < arr[i]) {
                lis[hi] = arr[i];
                list.get(hi).add(arr[i]);
                hi++;
            } else {
                int idx = binarySearch(lo, hi, arr[i]);
                lis[idx] = arr[i];
                list.get(idx).add(arr[i]);
            }
        }
        loop:
        for (int i = hi-2; i >= 0; i--) {
            ArrayList<Integer> cur = list.get(i);
            for (int j = 0; j < cur.size(); j++) {
                if (lis[i+1] > cur.get(j)) {
                    lis[i] = cur.get(j);
                    continue loop;
                }
            }
        }

        bw.write(hi+"");
        bw.newLine();
        for (int i = 0; i < hi; i++) {
            bw.write(lis[i]+" ");
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