package Problem_Solve;

import java.io.*;
import java.util.StringTokenizer;

public class _1074_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        try {   // 목표에 도달하면 종료하기 위해 커스텀 에러 생성
            recursion(0, 0, 1 << N);
        } catch (CustomException e) {
            System.out.println(result);
        }
    }
    static int r,c,result;
    static void recursion(int x, int y, int N) throws CustomException {
        if (x == r&& y == c) {  // 목표에 도착
            throw new CustomException();
        }
        if (N == 1) {   // 최대로 쪼갤 경우
            result++;
            return;
        }
        // 해당 조각에 없는 경우
        if (!(x <= r && r < x+N && y<=c && c<y+N)) {
            result += N*N;
            return;
        }
        N = N >> 1;
        recursion(x, y,N);
        recursion(x+N, y,N);
        recursion(x, y+N,N);
        recursion(x+N, y+N,N);
    }
}
class CustomException extends Exception {
    public CustomException() {}
}
