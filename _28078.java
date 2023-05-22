package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.Deque;

public class _28078 {
    static Deque<Character> d = new LinkedList<>();
    static int compass = 0;
    static int wall = 0;
    static int ball = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(2);
            char b;
            switch (a) {
                case 's':
                    b = st.nextToken().charAt(0);
                    d.add(b);
                    if (b == 'b') {
                        ball++;
                    } else{
                        wall++;
                    }
                    break;
                case 'p':
                    if (!d.isEmpty()) {
                        if (d.remove() == 'b') {
                            ball--;
                        } else {
                            wall--;
                        }
                    }
                    break;
                case 't':
                    b = st.nextToken().charAt(0);
                    if (b == 'l') {
                        compass = (4 + compass - 1) % 4;
                    }else {
                        compass = (compass + 1) % 4;
                    }
                    break;
                case 'u':
                    b = st.nextToken().charAt(0);
                    if (b == 'b') {
                        bw.write(ball+"");
                    }else {
                        bw.write(wall+"");
                    }
                    bw.newLine();
                    break;
            }
            if (!d.isEmpty()) {
                if (compass == 1) {
                    while (!d.isEmpty() && d.getFirst() != 'w') {
                        d.removeFirst();
                        ball--;
                    }
                } else if (compass == 3) {
                    while (!d.isEmpty() && d.getLast() != 'w') {
                        d.removeLast();
                        ball--;
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}