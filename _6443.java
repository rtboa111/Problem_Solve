package Problem_Solve;

import java.io.*;

public class _6443 {

    static int len;
    static int[] count, check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] word = br.readLine().toCharArray();
            sb = new StringBuilder();
            len = word.length;
            count = new int[26];
            check = new int[26];
            for(char j : word) {
                count[j - 'a']++;
            }
            backtracking(0, new char[len]);

            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
    static void backtracking(int idx, char[] ans) {
        if(idx == len) {
            sb.append(ans).append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (check[i] < count[i]) {
                check[i]++;
                ans[idx] = (char) (i + 'a');
                backtracking(idx+1, ans);
                check[i]--;
            }
        }
    }
}