package Problem_Solve.Arena.GrandArena_1;

import java.io.*;
import java.util.StringTokenizer;

public class G {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = 100000;
        int n = Integer.parseInt(br.readLine());
        int[] check = new int[num+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            check[cur] = 1;
        }
        for (int i = 1; i <= num; i++) {
            if (check[i] == 0) {
                continue;
            }
            for (int j = i << 1; j <= num; j += i) {
                check[j] += check[i];
            }
        }
        int q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int cur = Integer.parseInt(st.nextToken());
            bw.write(check[cur] + " ");
        }
        bw.flush();
        bw.close();
    }
}

