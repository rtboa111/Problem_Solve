package Problem_Solve;

import java.io.*;

public class _28086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int idx = 1;
        while (s.charAt(idx) >= '0' && s.charAt(idx) <= '7') {
            idx++;
        }
        long A = Integer.parseInt(s.substring(0, idx));
        A = toDecimal(A);
        char operator = s.charAt(idx);
        long B = Integer.parseInt(s.substring(idx+1));
        B = toDecimal(B);
        long result = operate(operator, A, B);
        result = toOctal(result);
        if (invalid) {
            System.out.println("invalid");
        } else {
            System.out.println(result);
        }
    }
    static long toOctal(long decimal) {
        long digit = 1;
        long result = 0;
        while (decimal != 0) {
            result += (decimal % 8) * digit;
            decimal /= 8;
            digit *= 10;
        }
        return result;
    }
    static long toDecimal(long octal) {
        long digit = 1;
        long result = 0;
        while (octal != 0) {
            result += (octal % 10) * digit;
            octal /= 10;
            digit *= 8;
        }
        return result;
    }
    static boolean invalid = false;
    static long operate(char operator, long A, long B) {
        if (B == 0 && operator == '/') {
            invalid = true;
            return 0;
        }
        long result = 0;
        switch (operator) {
            case '+':
                result = A + B;
                break;
            case '-':
                result = A - B;
                break;
            case '*':
                result = A * B;
                break;
            case '/':
                long tmp = (Math.abs(A) / Math.abs(B));
                if ((A < 0) ^ (B < 0)) {
                    if (A % B == 0) {
                        result = -tmp;
                    } else {    // 음수이고 나누어 떨어지지 않으면 반올림을 위해 +1
                        result = -(tmp + 1);
                    }
                } else {
                    result = tmp;
                }
                break;
        }
        return result;
    }
}
