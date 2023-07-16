package Problem_Solve;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _3425 {

    static final long MAX_NUM = 1000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        loop1:
        while (true) {
            Deque<String> deque = new LinkedList<>();
            while (true) {
                String cur = br.readLine();
                if (cur.charAt(0) == 'E') {
                    break;
                } else if (cur.charAt(0) == 'Q') {
                    break loop1;
                }
                deque.addLast(cur);
            }
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                Stack<Long> stack = new Stack<>();
                stack.add(Long.parseLong(br.readLine()));
                long fir, sec;
                loop2:
                for (String o : deque) {
                    switch (o.charAt(0)) {
                        case 'N':
                            String[] s = o.split(" ");
                            stack.add(Long.parseLong(s[1]));
                            break;
                        case 'P':
                            if (stack.isEmpty()) {
                                break loop2;
                            }
                            stack.pop();
                            break;
                        case 'I':
                            if (stack.isEmpty()) {
                                break loop2;
                            }
                            fir = stack.pop();
                            stack.add(-fir);
                            break;
                        case 'D':
                            if (stack.isEmpty()) {
                                break loop2;
                            }
                            if (o.charAt(1) == 'U') {
                                stack.add(stack.peek());
                            } else {
                                if (stack.size() < 2) {
                                    stack.add(MAX_NUM + 1);
                                    break loop2;
                                }
                                fir = stack.pop();
                                sec = stack.pop();
                                if (fir == 0) {
                                    stack.add(sec);
                                    stack.add(MAX_NUM + 1);
                                    break loop2;
                                }
                                stack.add(sec / fir);
                            }
                            break;
                        case 'S':
                            if (stack.size() < 2) {
                                stack.add(MAX_NUM + 1);
                                break loop2;
                            }
                            fir = stack.pop();
                            sec = stack.pop();
                            if (o.charAt(1) == 'W') {
                                stack.add(fir);
                                stack.add(sec);
                            } else {
                                if (Math.abs(sec - fir) > MAX_NUM) {
                                    stack.add(sec);
                                    stack.add(MAX_NUM + 1);
                                    break loop2;
                                }
                                stack.add(sec - fir);
                            }
                            break;
                        case 'A':
                            if (stack.size() < 2) {
                                stack.add(MAX_NUM + 1);
                                break loop2;
                            }
                            fir = stack.pop();
                            sec = stack.pop();
                            if (Math.abs(fir + sec) > MAX_NUM) {
                                stack.add(sec);
                                stack.add(MAX_NUM + 1);
                                break loop2;
                            }
                            stack.add(fir + sec);
                            break;
                        case 'M':
                            if (stack.size() < 2) {
                                stack.add(MAX_NUM + 1);
                                break loop2;
                            }
                            fir = stack.pop();
                            sec = stack.pop();
                            if (o.charAt(1) == 'U') {
                                if (Math.abs(fir * sec) > MAX_NUM) {
                                    stack.add(sec);
                                    stack.add(MAX_NUM + 1);
                                    break loop2;
                                }
                                stack.add(fir * sec);
                            } else {
                                if (fir == 0) {
                                    stack.add(sec);
                                    stack.add(MAX_NUM + 1);
                                    break loop2;
                                }
                                stack.add(sec % fir);
                            }
                            break;
                    }
                }
                if (stack.size() == 1 && stack.peek() <= MAX_NUM) {
                    bw.write(stack.pop() + "");
                } else {
                    bw.write("ERROR");
                }
                bw.newLine();
            }
            bw.newLine();

            br.readLine();
        }
        bw.flush();
        bw.close();
    }
}