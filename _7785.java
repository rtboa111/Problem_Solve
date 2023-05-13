package Problem_Solve;

import java.io.*;
import java.util.*;

public class _7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Map<String, Character> log = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            char state = st.nextToken().charAt(0);
            log.put(name, state);
        }
        for (String s : log.keySet()) {
            if (log.get(s) == 'e') {
                bw.write(s);
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
