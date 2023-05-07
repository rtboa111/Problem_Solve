package Problem_Solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992 {

    static int[][] QT;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        QT = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                QT[i][j] = br.read()-48;
            }
            br.read();  // "\n"
        }
        cut(N,0,0);
        System.out.println(sb);
    }

    static void cut(int size, int x, int y) {
        if (possible(size, x, y)) { // 같은 수로 구성 된 경우
            sb.append(QT[y][x]);
        }
        else {  // 같은 수로 구성이 안되어 있는 경우
            int new_size = size >> 1;
            sb.append("(");
            cut(new_size, x, y);
            cut(new_size, x + new_size, y);
            cut(new_size, x, y + new_size);
            cut(new_size, x + new_size, y + new_size);
            sb.append(")");
        }
    }
    // 모두 같은 수로 되어있는지 확인
    static boolean possible(int size, int x, int y) {
        int val = QT[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (val != QT[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}