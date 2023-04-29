package Problem_Solve;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 큐 를 통해
 */
public class _1966 {

    public static int M;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            count = 0;

            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> Q = new ArrayList<>(N);
            while (st.hasMoreTokens()) {
                Q.add(Integer.parseInt(st.nextToken()));
            }

            while (!send_back(see(Q), Q));
            sb.append(count+1).append("\n");
        }
        System.out.println(sb);
    }

    static int see(ArrayList<Integer> Q) {
        int x = Q.get(0);
        int max = 0;
        for (int i = 0; i < Q.size(); i++) {
            if (x < Q.get(i)) {
                x = Q.get(i);
                max = i;
            }
        }
        return max;
    }
    static boolean send_back(int j, ArrayList<Integer> Q) {
        for (int i = 0; i < j; i++) {
            Q.add(Q.remove(0));
            if (--M< 0) {
                M = Q.size()-1;
            }
        }
        if (M == 0) {
            return true;
        }
        Q.remove(0);
        M--;
        count++;
        return false;
    }
}
