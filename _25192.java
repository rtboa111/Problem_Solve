package Problem_Solve;

import java.io.*;
import java.util.HashSet;
/*
 * 채팅의 이모티콘 사용 횟수
 *
 * 아이디가 입력되면 중복을 허용하지 않고 배열에 저장
 * ENTER 가 입력되면 그전까지 입력된 아이디가
 * 몇 개인지 확인하고 그 수 를 더함
 */
public class _25192 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        String x = br.readLine();
        HashSet<String> name = new HashSet<>(N);
        for (int i = 0; i < N-1; i++) {
            x = br.readLine();
            if (x.equals("ENTER")) {
                count += name.size();
                name.clear();
            } else {
                name.add(x);
            }
        }
        count += name.size();
        System.out.println(count);
    }
}

