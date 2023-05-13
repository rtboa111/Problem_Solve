package Problem_Solve;

import java.io.*;
import java.util.*;

public class _10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> card = new HashSet<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (card.contains(Integer.parseInt(st.nextToken()))) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}
