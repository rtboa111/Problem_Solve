package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Deque;
import java.util.Stack;

public class _17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> res = new LinkedList<>();
        for (int i = N-1; i >= 0; i--) {
            int cur = arr[i];
            while (!stack.isEmpty() && cur >= stack.peek()) {
                stack.pop();
            }
            res.addFirst((stack.isEmpty()) ? -1 : stack.peek());
            stack.add(cur);
        }

        for (int i : res) {
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }
}