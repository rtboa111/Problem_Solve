package Problem_Solve;

import java.io.*;
import java.util.*;

public class _9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            Map<String, Integer> cloth = new HashMap<>(k);
            int count = 1;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                // 같은 종류의 옷은 갯수만 카운팅
                cloth.put(type, cloth.getOrDefault(type, 0) + 1);
            }
            /*
             * n 개의 옷이 속한 옷의 종류에서
             * 한가지를 선택 하는데 그 종류를 고르지 않는
             * 경우도 존재하므로 n+1C1,
             * 모든 경우의 수는 모든 옷의 종류에 대해서
             * 선택을 하는 것이므로 종류당 경우의 수들을
             * 모두 곱한다.
             */
            for (String s : cloth.keySet()) {
                count *= cloth.get(s)+1;
            }
            count--;    // 알몸인 경우는 제외(모두 선택하지 않는 경우)
            bw.write(count+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}