package Problem_Solve;

import java.io.*;
import java.util.*;

public class _1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long later = 1;
        // 지수를 반씩 줄여가고 나머지 계산할 부분 따로 저장
        while (B > 1) {
            if (B % 2 != 0) {
                later = ((later % C) * (A % C)) % C;
            }
            A = ((A % C) * (A % C)) % C;
            B /= 2;
        }
        System.out.println(((A % C) * (later % C)) % C);
    }
}