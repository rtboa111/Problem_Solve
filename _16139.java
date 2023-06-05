package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] string = br.readLine().toCharArray();
        int len = string.length+1;
        int[] prefixSum = new int[26*(len)];
        for (int i = 1; i < len; i++) {
            int cur = string[i-1] - 'a';
            prefixSum[cur*len+i]++;
            for (int j = 0; j < 26; j++) {
                prefixSum[j*len+i] += prefixSum[j*len+(i-1)];
            }
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken())+1;
            bw.write(prefixSum[cur*len+r] - prefixSum[cur*len+l] + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}