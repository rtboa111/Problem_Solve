package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _5430 {

    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] p; int[] arr; int n; String s;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            p = br.readLine().toCharArray();
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            s = br.readLine();
            st = new StringTokenizer(s.substring(1,s.length()-1), ",");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            execute(p, arr.length, arr);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void execute(char[] p, int length, int[] arr) throws IOException {
        int[] len = new int[]{0, length};
        boolean isStart = true;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 'R') {
                isStart = !isStart;
            } else {
                if (isStart) {
                    len[0]++;
                } else {
                    len[1]--;
                }
                if (len[0] > len[1]) {
                    break;
                }
            }
        }
        if (len[0] > len[1]) {
            bw.write("error");
        } else {
            bw.write("[");
            if (len[0] == len[1]) {
                bw.write("]");
            } else {
                if (isStart) {
                    for (int i = len[0]; i < len[1]-1; i++) {
                        bw.write(arr[i]+",");
                    }
                    bw.write(arr[len[1]-1]+"]");
                } else {
                    for (int i = len[1]-1; i > len[0]; i--) {
                        bw.write(arr[i]+",");
                    }
                    bw.write(arr[len[0]]+"]");
                }
            }

        }
    }
}