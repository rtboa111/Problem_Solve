package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Deque;

public class _9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] string = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();
        Deque<Character> d = new LinkedList<>();
        for (int i = 0; i < string.length; i++) {
            char cur = string[i];
            d.add(cur);
            int boomLen = boom.length-1;
            while (!d.isEmpty() && d.peekLast() == boom[boomLen]) {
                Deque<Character> q = new LinkedList<>();
                while (!d.isEmpty() && boomLen >= 0 && d.peekLast() == boom[boomLen]) {
                    q.addFirst(d.removeLast());
                    boomLen--;
                }
                if (boomLen >= 0) {
                    d.addAll(q);
                    break;
                }
                boomLen = boom.length-1;
            }
        }

        if (d.isEmpty()) {
            bw.write("FRULA");;
        } else {
            for (char s : d) {
                bw.write(s+"");
            }
        }
        bw.flush();
        bw.close();
    }
}