package Problem_Solve;

import java.io.*;
import java.util.*;

public class _11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int x = 0;
        for (int i = 1; i <= N; i++) {
            x += Integer.parseInt(st.nextToken());
            arr[i] = x;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(arr[b] - arr[a-1] + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}