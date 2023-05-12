package Problem_Solve;

import java.io.*;
import java.util.*;

public class _17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> secret = new HashMap<>(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            secret.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            String site = br.readLine();
            bw.write(secret.get(site));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}