package Problem_Solve;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 듣도 못한사람 수
        int M = Integer.parseInt(st.nextToken());   // 보도 못한사람 수
        String[] parson = new String[N+M];

        for (int i = 0; i < N+M; i++) {
            parson[i] = br.readLine();
        }

        Arrays.sort(parson);    // 사전순 정렬
        int count = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+M; i++) {
            // 전 인덱스와 동일한 것이 듣도보도 못한 사람 이므로 StringBuilder 에 추가
            if (parson[i].equals(parson[i-1])) {
                sb.append(parson[i]).append("\n");
                count++;
            }
        }
        sb.insert(0, count+"\n");   // 앞쪽에 사람 수 추가
        System.out.println(sb);
    }
}
