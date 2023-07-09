package Problem_Solve;

import java.io.*;
import java.util.Stack;

public class _5076 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        loop:
        while (true) {
            char[] line = br.readLine().toCharArray();
            int len = line.length;
            if (len == 0) {
                bw.write("legal");
                bw.newLine();
                continue;
            }
            if (line[0] == '#') break;

            java.util.Stack<String> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                if (line[i] == '<') {
                    i++;
                    if (line[i] == '/') {
                        i++;
                        String cur = "";
                        while (line[i] != '>') {
                            cur += line[i];
                            i++;
                        }
                        if (!stack.isEmpty() && cur.equals(stack.peek())) {
                            stack.pop();
                        } else if (stack.isEmpty()){
                            bw.write("illegal");
                            bw.newLine();
                            continue loop;
                        }
                    }  else if (line[i] == 'a') {
                        stack.add("a");
                    } else {
                        String cur = "";
                        while (line[i] != '>') {
                            cur += line[i];
                            i++;
                        }
                        if (cur.charAt(cur.length()-1) == '/') {
                            continue;
                        }
                        stack.add(cur);
                    }
                }
            }
            if (stack.isEmpty()) {
                bw.write("legal");
                bw.newLine();
            } else {
                bw.write("illegal");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}