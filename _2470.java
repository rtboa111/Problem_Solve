package Problem_Solve;

import java.io.*;
import java.util.*;

public class _2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(((o1, o2) -> Math.abs(o1) - Math.abs(o2)));
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (min > Math.abs(arr.get(i-1) + arr.get(i))) {
                min = Math.abs(arr.get(i-1) + arr.get(i));
                idx = i;
            }
        }
        System.out.println(Math.min(arr.get(idx-1), arr.get(idx)) + " " + Math.max(arr.get(idx-1), arr.get(idx)));
    }
}