package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int x;
        for (int i = 0; i < A; i++) {
            x = Integer.parseInt(st.nextToken());
            set.add(x);
        }
        int count = A;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            x = Integer.parseInt(st.nextToken());
            if (set.contains(x)) {
                count--;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}
