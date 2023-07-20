package Problem_Solve;

import java.io.*;
import java.util.Stack;

public class _9252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = ("a" + br.readLine()).toCharArray();
        char[] str2 = ("a" + br.readLine()).toCharArray();
        int len1 = str1.length;
        int len2 = str2.length;

        int[][] dp = new int[len1][len2];
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[len1-1][len2-1]);
        if (dp[len1-1][len2-1] > 0) {
            sb.append("\n");
            Stack<Character> stack = new Stack<>();
            for (int i = len1-1, j = len2-1; i > 0 && j > 0; ) {
                if (str1[i] == str2[j]) {
                    stack.add(str1[i--]);
                    j--;
                } else {
                    if (dp[i][j-1] == dp[i][j]) {
                        j--;
                    } else {
                        i--;
                    }
                }
            }
            while (!stack.isEmpty()) sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}