package Problem_Solve;

import java.io.*;
import java.util.Stack;

public class _3015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] line = new long[N];
        for (int i = 0; i < N; i++) {
            line[i] = Long.parseLong(br.readLine());
        }
        Stack<long[]> stack = new Stack<>();

        long res = 0;
        for (int i = N-1; i >= 0; i--) {
            long cur = line[i];
            long cnt = 0;
            while (!stack.isEmpty() && cur >= stack.peek()[0]) {
                if (cur == stack.peek()[0]) {
                    cnt += stack.pop()[1] + 1;
                } else {
                    res += stack.pop()[1] + 1;
                }
            }
            res += (stack.isEmpty()) ? cnt : cnt + 1;
            stack.add(new long[]{cur, cnt});
        }
        System.out.println(res);
    }
}