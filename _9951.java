package Problem_Solve;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class _9951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        loop:
        while (true) {
            st = new StringTokenizer(br.readLine());
            ArrayList<String> arr = new ArrayList<>();
            while (st.hasMoreElements()) {
                char[] s = st.nextToken().toLowerCase().toCharArray();
                if (s[0] == '#') break loop;
                StringBuilder S = new StringBuilder();
                int num = 0;
                for (char i : s) {
                    if (i >= 'a' && i <= 'z') {
                        S.append(i);
                    } else if (i >= '0' && i <= '9') {
                        S.append(i);
                        num++;
                    }
                }
                if (num == S.length()) continue;
                arr.add(S.toString());
            }
            arr = arr.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
            arr.sort(CharSequence::compare);
            for (String i : arr) {
                bw.write(i.toLowerCase());
                bw.newLine();
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }

}
