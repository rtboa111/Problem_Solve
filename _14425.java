package Problem_Solve;

import java.io.*;
import java.util.*;

public class _14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> arr = new HashSet<>(N);
        for (int i = 0; i <N; i++) {
            arr.add(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (arr.contains(br.readLine())) count++;
        }
        System.out.println(count);
    }
}
