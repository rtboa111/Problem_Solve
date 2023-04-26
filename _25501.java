package Problem_Solve;

import java.io.*;
/*
 * 문자열의 팰린드롬 확인
 *
 * 재귀함수를 통한 문자열의 팰린드롬 검사와
 * 재귀호출 횟수 출력
 */
public class _25501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] s = br.readLine().toCharArray();
            sb.append(isPalindrome(s, 0, s.length-1)).append(" ").append(count).append("\n");
            count = 0;
        }
        System.out.println(sb);
    }
    public static int count = 0;
    public static int isPalindrome(char[] s, int lo, int hi) {
        count++;
        if (lo >= hi) {
            return 1;
        }
        else if (s[lo] != s[hi]) {
            return 0;
        }
        return isPalindrome(s, ++lo, --hi);
    }
}
