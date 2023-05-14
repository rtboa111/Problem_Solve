package Problem_Solve;


import java.io.*;
import java.util.StringTokenizer;

public class _1011 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int x, y;
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            bw.write(min_shift(x, y, 0) + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int min_shift(int x, int y, int count) {

        int a = 1;
        int b = 1;
        while (true) {
            if (x < y) {
                x += a++;
                count++;
            } else {
                break;
            }
            if (x < y) {
                y -= b++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}