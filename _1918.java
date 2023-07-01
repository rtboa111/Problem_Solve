package Problem_Solve;

import java.io.*;
import java.util.Stack;

public class _1918 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] mid = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        java.util.Stack<Character> stack = new Stack<>();
        for (char s : mid) {
            if (s >= 'A' && s <= 'Z') {
                sb.append(s);
            } else if (s == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                if (s == '*' || s == '/') {
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        sb.append(stack.pop());
                    }
                    stack.add(s);
                } else if (s == '(') {
                    stack.add(s);
                } else {
                    while (!stack.isEmpty() && (stack.peek() != '(')) {
                        sb.append(stack.pop());
                    }
                    stack.add(s);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}