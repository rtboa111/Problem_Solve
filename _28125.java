package Problem_Solve;

import java.io.*;

public class _28125 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '\\') {
                    if (s.charAt(j + 1) == '\\') {
                        sb.append(change('\\'));
                        j++;
                    } else {
                        sb.append(change('\''));
                    }
                    j++;
                    count++;
                } else {
                    char cur = s.charAt(j);
                    if (cur != change(s.charAt(j))) {
                        count++;
                    }
                    sb.append(change(cur));
                }
            }
            if ((count<<1) >= sb.length()) {
                sb = new StringBuilder();
                sb.append("I don't understand");
            }
            System.out.println(sb);
        }

    }
    static char change(char x) {
        switch (x) {
            case '@':
                return 'a';
            case '[':
                return 'c';
            case '!':
                return 'i';
            case ';':
                return 'j';
            case '^':
                return 'n';
            case '0':
                return 'o';
            case '7':
                return 't';
            case '\'':
                return 'v';
            case '\\':
                return 'w';
        }
        return x;
    }
}

