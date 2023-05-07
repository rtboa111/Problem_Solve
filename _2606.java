package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _2606 {

    static boolean[] check;
    static int N,count;
    static boolean[][] connection;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        connection = new boolean[N][N];
        check = new boolean[N];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            connection[from][to] = true;    // 양방향 연결
            connection[to][from] = true;
        }
        count = 0;
        search(0);
        System.out.println(count-1);
    }

    static void search(int start) {
        check[start] = true;
        count++;
        for(int i = 0; i <= N; i++) {
            if(connection[start][i]&&!check[i]) {
                search(i);
            }
        }
    }
}