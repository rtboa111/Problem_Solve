package Problem_Solve;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> pokemon = new HashMap<>(N); // 문자열 검색에 좋음
        String[] pokemon2 = new String[N+1];
        for (int i = 1; i < N+1; i++) {   // 포켓몬 도감에 입력
            pokemon2[i] = br.readLine();
            pokemon.put(pokemon2[i],i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {   // 포켓몬 문제
            String problem = br.readLine();
            if (problem.charAt(0) < 58 && problem.charAt(0) > 48) { // 숫자면
                int number = Integer.parseInt(problem);
                sb.append(pokemon2[number]).append("\n");
            } else {    // 문자면
                sb.append(pokemon.get(problem)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
