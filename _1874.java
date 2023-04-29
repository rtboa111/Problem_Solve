package Problem_Solve;

import java.io.*;
import java.util.Stack;
/*
 * 입력되는 1부터 n 까지의 무작위 배열을
 * 1부터 n까지 스택에 넣으며 출력 했을 때
 * 해당 배열이 완성되는 여부와 완성이 된다면
 * 어떻게 push()와 pop()이 입력되야 하는지를 출력
 *
 * 입력되는 무작위 배열의 숫자가 되는 지점까지
 * 스택에 1부터 push 하고 마지막 입력된 숫자를 pop 한다
 * (push 와 pop 을 할 때 마다 기록함)
 * push 되는 수가 n을 넘거나 pop 을 해야할 때
 * 스택이 비여있으면 목표 배열 완성이 불가능 한 것이므로
 * NO 를 출력한다.
 */
public class _1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int top = 0;
        int num = 0;
        boolean no = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!stack.empty())
                top = stack.peek();

            int target = Integer.parseInt(br.readLine());
            while (target != top) {
                stack.push(++num);
                top = num;
                sb.append("+").append("\n");
                if (num > n) {
                    no = true;
                    break;
                }
            }

            if (no || stack.empty()) {
                sb = new StringBuilder("NO");
                break;
            } else {
                stack.pop();
                sb.append("-").append("\n");
            }


        }
        System.out.println(sb);
    }
}
