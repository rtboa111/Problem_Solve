package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Deque;
import java.util.Stack;

public class _17299 {

    static final int max = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[max];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur; count[cur]++;
        }
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> res = new LinkedList<>();
        for (int i = N-1; i >= 0; i--) {
            int cur = arr[i];
            while (!stack.isEmpty() && count[cur] >= count[stack.peek()]) {
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