package Problem_Solve;

import java.io.*;

public class _17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i ++) {
            char[] string = br.readLine().toCharArray();
            bw.write((Math.min(pointer(string, 0, 0, string.length-1), 2))+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static int pointer(char[] string, int cnt, int lo, int hi) {
        for(int i = lo, j = hi; i < j && cnt < 2; i++, j--) {
            if(string[i] != string[j]) {
                cnt++;
                if (string[i] == string[j-1] && string[i+1] == string[j]) {
                    return Math.min(pointer(string, cnt, i, j-1), pointer(string, cnt, i+1, j));
                } else if (string[i] == string[j-1]) {
                    i--;
                } else if (string[i+1] == string[j]){
                    j++;
                } else {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}