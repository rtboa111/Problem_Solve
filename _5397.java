package Problem_Solve;

import java.io.*;
import java.util.*;

public class _5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            List<Character> list = new LinkedList<>();
            int cursor = -1;
            for (int j = 0; j < input.length; j++) {
                char o = input[j];
                if (o == '<') {
                    if (cursor >= 0) {
                        cursor--;
                    }
                } else if (o == '>') {
                    if (cursor < list.size()-1) {
                        cursor++;
                    }
                } else if (o == '-') {
                    if (!list.isEmpty() && cursor >= 0) {
                        list.remove(cursor);
                        cursor--;
                    }
                } else {
                    list.add(cursor+1, o);
                    cursor++;
                }
            }
            for (char s : list) {
                bw.write(s+"");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}