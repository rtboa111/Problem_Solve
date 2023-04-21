package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;
/*
 * 문자열을 받아 괄호에 관한 처리를 하는 문제
 *
 * 괄호만 골라 배열에 넣음
 * 원하는 규칙을 따르지 않으면 넣지 않고 종료
 */
public class _4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int s;
        while ((s = br.read()) != 46) {
            boolean S = true;
            boolean S2 = true;
            balance bal = new balance();
            while (S2) {
                switch (s) {
                    case 40:
                        S = bal.put('(');
                        break;
                    case 41:
                        S = bal.put2(')');
                        break;
                    case 91:
                        S = bal.put('[');
                        break;
                    case 93:
                        S = bal.put2(']');
                        break;
                    case 46:
                        if (bal.empty()) {
                            sb.append("yes").append("\n");
                        } else {
                            sb.append("no").append("\n");
                        }
                        S2 = false;
                        break;
                }
                if (!S) {
                    sb.append("no").append("\n");
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    break;
                }
                s = br.read();
            }
        }
        System.out.println(sb);
    }
}
class balance {
    private char[] a;
    private int size;
    public balance() {
        this.a = new char[101];
        this.size = 1;
    }
    public boolean empty() {
        return size==1;
    }
    public boolean put(char z) {
        a[size++] = z;
        return true;
    }
    public boolean put2(char z) {
        int s = a[size-1]-z;
        if (s < -3||s > 0) {
            return false;
        }
        a[--size] = 0;
        return true;
    }
}
